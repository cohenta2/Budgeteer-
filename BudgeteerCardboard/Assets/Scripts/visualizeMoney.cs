using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.Networking;

namespace Assets.Scripts
{

    // Handles visualization/animation of the money stacks based on a user's budget
    public class visualizeMoney : MonoBehaviour
    {
        // Text objects are bound in Unity environment
        private UserBudget userBudget;
        public Text foodValue;
        public Text recreationValue;
        public Text rentValue;
        public Text transportationValue;
        public Text incomeValue;

        private NetworkUtils networkUtils;

        // initialize all text objects based on user's budget
        IEnumerator Start()
        {
            networkUtils = GetComponent<NetworkUtils>();
            networkUtils.enabled = true;
            // Ensures we get the data before modifying UI
            yield return StartCoroutine(networkUtils.getInfoFromHttpRequest());
            userBudget = networkUtils.getBudgetForUser();

            foodValue.text = userBudget.food.ToString("C");
            recreationValue.text = userBudget.recreation.ToString("C");
            rentValue.text = userBudget.rent.ToString("C");
            transportationValue.text = userBudget.transportation.ToString("C");
            incomeValue.text = userBudget.income.ToString("C");
        }

        // Update is called once per frame
        void Update()
        {

        }

        /* UNDER DEVELOPMENT
        void getUserName()
        {
            AndroidJavaClass UnityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
            AndroidJavaObject currentActivity = UnityPlayer.GetStatic<AndroidJavaObject>("currentActivity");

            AndroidJavaObject intent = currentActivity.Call<AndroidJavaObject>("getIntent");
            AndroidJavaObject extras = intent.Call<AndroidJavaObject>("getExtras");
            string arguments = extras.Call<string>("getString", "arguments");
            Debug.Log(arguments);
        }
        */
    }
}
