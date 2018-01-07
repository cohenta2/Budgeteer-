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
        private string username;

        // Text objects are bound in Unity environment
        public Text foodValue;
        public Text recreationValue;
        public Text rentValue;
        public Text transportationValue;
        public Text incomeValue;

        private UserBudget userBudget;
        private NetworkUtils networkUtils;

        // initialize all text objects based on user's budget
        IEnumerator Start()
        {
            networkUtils = GetComponent<NetworkUtils>();
            networkUtils.enabled = true;
            username = getUserName();
            Debug.Log(username);
            // Ensures we get the data before modifying UI
            yield return StartCoroutine(networkUtils.getInfoFromHttpRequest(username));
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

        
        string getUserName()
        {
            AndroidJavaClass pluginClass = new AndroidJavaClass("com.example.coreysutphin.budgeteer");
            return pluginClass.CallStatic<string>("getUsername");
        }
        
    }
}
