package com.example.cluedapp

data class Question(
    val id: Int,
    val text: String,
    val isTrue: Boolean,
    val category: String
)

object QuizRepository {

    fun getQuestions(): List<Question> {
        return listOf(
            // HEALTH (TRUE)
            Question(1, "The 20-20 rule reduces eye strain from screens", true, "Health"),
            Question(2, "Regular exercise can improve mental health", true, "Health"),
            Question(3, "Fruits and vegetables are important sources of vitamins", true, "Health"),
            Question(4, "Spending time outdoors benefits mental health", true, "Health"),
            Question(5, "Reading food labels helps you make healthier choices", true, "Health"),

            // HEALTH (FALSE)
            Question(6, "Eating carrots gives you night vision", false, "Health"),
            Question(7, "Detox teas remove toxins from the body", false, "Health"),
            Question(8, "Expensive supplements are necessary to stay healthy", false, "Health"),
            Question(9, "Stretching prevents all injuries", false, "Health"),
            Question(10, "Skipping meals is a healthy way to lose weight", false, "Health"),

            // CLEANING (TRUE)
            Question(11, "Baking soda in the fridge absorbs odour", true, "Cleaning"),
            Question(12, "Hot water cleans better than cold water", true, "Cleaning"),
            Question(13, "Cleaning a little daily reduces deep cleaning", true, "Cleaning"),
            Question(14, "Air-drying clothes reduces electricity cost", true, "Cleaning"),
            Question(15, "Reusable cloths save money over time", true, "Cleaning"),

            // CLEANING (FALSE)
            Question(16, "Coca-Cola cleans greasy floors better than soap", false, "Cleaning"),
            Question(17, "Cleaning and disinfecting are the same", false, "Cleaning"),
            Question(18, "Making your bed has no effect on cleanliness", false, "Cleaning"),
            Question(19, "Mixing cleaning products makes them better", false, "Cleaning"),
            Question(20, "Newspaper is best for cleaning windows", false, "Cleaning"),

            // PRODUCTIVITY (TRUE)
            Question(21, "Pomodoro technique helps focus", true, "Productivity"),
            Question(22, "Structured routines improve time management", true, "Productivity"),
            Question(23, "Budget tracking avoids unnecessary spending", true, "Productivity"),
            Question(24, "To-do lists help you stay organized", true, "Productivity"),
            Question(25, "Tracking progress improves productivity", true, "Productivity"),

            // PRODUCTIVITY (FALSE)
            Question(26, "Drinking coffee all day keeps you productive", false, "Productivity"),
            Question(27, "Procrastination improves work quality", false, "Productivity"),
            Question(28, "Buying on sale always saves money", false, "Productivity"),
            Question(29, "Waking early guarantees productivity", false, "Productivity"),
            Question(30, "Being busy means being productive", false, "Productivity")
        )
    }
}
