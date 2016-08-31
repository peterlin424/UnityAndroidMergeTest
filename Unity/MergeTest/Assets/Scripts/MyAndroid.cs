using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using Vuforia;

public class MyAndroid : MonoBehaviour {


	// Use this for initialization
	void Start () {
		VuforiaBehaviour.Instance.RegisterVuforiaStartedCallback (OnVuforiaStarted);
		VuforiaBehaviour.Instance.RegisterOnPauseCallback (OnVuforiaPaused);
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

	private void OnVuforiaStarted() {
		bool focusModeSet = CameraDevice.Instance.SetFocusMode (CameraDevice.FocusMode.FOCUS_MODE_CONTINUOUSAUTO);
		if (!focusModeSet) {
			Debug.Log ("Failed to set focus mode (unsupported mode).");
		}
	}

	private void OnVuforiaPaused(bool paused) {
		if (!paused) {
			// Set again autofocus mode when app is resumed
			bool focusModeSet = CameraDevice.Instance.SetFocusMode (CameraDevice.FocusMode.FOCUS_MODE_CONTINUOUSAUTO);
			if (!focusModeSet) {
				Debug.Log ("Failed to set focus mode (unsupported mode).");
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
