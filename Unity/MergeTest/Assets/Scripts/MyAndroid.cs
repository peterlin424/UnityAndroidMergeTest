using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class MyAndroid : MonoBehaviour {


	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
		if (Application.platform == RuntimePlatform.Android) {
			if (Input.GetKey (KeyCode.Escape)) {
				Application.Quit ();
				return;
			}
		}
	}

	public void show() {
		AndroidJavaClass jc = new AndroidJavaClass("com.mergetest.peter.mergeproject.mUnityInterface");
		jc.CallStatic( "Show", "這是標題", "這是內文");
	}

	public void startActivity(){

		AndroidJavaClass jc = new AndroidJavaClass("com.mergetest.peter.mergeproject.mUnityActivity");
		AndroidJavaObject jo = jc.GetStatic<AndroidJavaObject> ("mCurrentActivity");
		jo.Call( "StartActivityNonStatic", jo );
	}

	public void getMessage(string msg){
		GameObject.Find ("Canvas/FromAndroidText").GetComponent<Text> ().text = msg;
	}
}
