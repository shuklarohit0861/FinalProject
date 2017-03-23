package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.util.Pair;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

/**
 * Created by g801845 on 3/23/2017.
 */
@RunWith(AndroidJUnit4.class)
public class testAsync  {

    @Rule
    public ActivityTestRule myActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void letsTest(){
      final EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        String result = null;
        Context context = myActivityRule.getActivity().getApplicationContext();

        endpointsAsyncTask.execute(new Pair<Context, String>(context,"string"));


        try{

            result = endpointsAsyncTask.get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(result.length()> 0 && !result.contains("failed"));


    }


}
