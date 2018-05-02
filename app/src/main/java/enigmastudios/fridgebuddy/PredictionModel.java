package enigmastudios.fridgebuddy;


import java.util.Date;

public class PredictionModel {

    double cornIntercept = 44.22481612;
    double cornCoefficient = -0.000000027292576;
    double butterCoefficient = 0.000000004646163;
    double butterIntercept = 2.33492356;

    Date today = new Date();
    static String prediction;

    PredictionModel(String food)
    {
        System.out.println(food) ;
        if(food.compareTo("Corn") == 0)
        {
            if(cornModelPrediction() < 0)
            {
                prediction = " will go down";
            }
            else
                {
                    prediction = " will go up";
                }
        }

        if(food.compareTo("Butter") == 0)
        {
            if(butterModelPrediction() < 0)
            {
                prediction =" will go down";
            }
            else
            {
                prediction = " will go up";
            }
        }
    }
    private double butterModelPrediction()
    {
        return butterCoefficient * today.getTime() + butterIntercept;
    }


    private double cornModelPrediction()
    {
        return cornCoefficient * today.getTime() + cornIntercept;
    }
}
