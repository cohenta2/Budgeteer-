using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Networking;

namespace Assets.Scripts
{

    // Used to grab a specific user's data from a web server, currently gets test user but should get info based on username
    public class NetworkUtils : MonoBehaviour
    {

        private UserBudget userBudget;

        void Awake()
        {
            StartCoroutine(getBudgetFromHttpRequest());
        }

        public IEnumerator getBudgetFromHttpRequest()
        {
            UnityWebRequest www = UnityWebRequest.Get("https://6kah5l5nc2.execute-api.us-east-1.amazonaws.com/dev?username=test3");
            yield return www.SendWebRequest();

            if (www.isNetworkError || www.isHttpError)
            {
                Debug.Log(www.error);
            }
            else
            {
                string jsonString = www.downloadHandler.text;
                userBudget = JsonUtility.FromJson<UserBudget>(jsonString);
                Debug.Log(userBudget.income);
                Debug.Log(userBudget.rent);
                Debug.Log(userBudget.username);
            }
        }

        // Call this in outside scripts to get access to user's data thorugh UserBudget's public fields
        public UserBudget getBudgetForUser()
        {
            return userBudget;
        }

    }
}