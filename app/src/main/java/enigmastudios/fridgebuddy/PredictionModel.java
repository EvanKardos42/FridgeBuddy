package enigmastudios.fridgebuddy;


import java.util.Date;

public class PredictionModel {

    double cornIntercept = 44.22481612;
    double cornCoefficient = -0.000000027292576;
    Date today = new Date();
    static String prediction;

    PredictionModel(String food)
    {
        System.out.println(food) ;
        if(food.compareTo("Corn") == 0)
        {
            if(cornModelPrediction() < 0)
            {
                prediction =" will do down";
            }
            else
                {
                    prediction = " will go up";
                }
        }
    }
    private double butterModel()
    {
        return 0;
    }


    private double cornModelPrediction()
    {
        return cornCoefficient * today.getTime() + cornIntercept;
    }
}
