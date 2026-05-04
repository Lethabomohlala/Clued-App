package com.example.cluedapp

data class Question(
    val id: Int,
    val text: String,
    val isTrue: Boolean,
    val category: String,
    val explanation: String
)

object QuizRepository {

    fun getQuestions(): List<Question> {
        return listOf(
            // HEALTH (TRUE)
            Question(1, "The 20-20 rule reduces eye strain from screens", true, "Health", "Taking regular breaks helps eye muscles relax and prevents digital eye strain."),
            Question(2, "Regular exercise can improve mental health", true, "Health", "Physical activity releases endorphins and reduces stress hormones, boosting mood."),
            Question(3, "Fruits and vegetables are important sources of vitamins", true, "Health", "Plants are primary sources of essential micronutrients that the body cannot produce."),
            Question(4, "Spending time outdoors benefits mental health", true, "Health", "Nature exposure lowers cortisol levels and improves emotional regulation."),
            Question(5, "Reading food labels helps you make healthier choices", true, "Health", "Labels provide transparency regarding calories, sugars, and fats to inform better diet choices."),

            // HEALTH (FALSE)
            Question(6, "Eating carrots gives you night vision", false, "Health", "While high in Vitamin A, they cannot grant night vision or improve vision beyond normal levels."),
            Question(7, "Detox teas remove toxins from the body", false, "Health", "The liver and kidneys already naturally filter toxins; these teas often just act as diuretics."),
            Question(8, "Expensive supplements are necessary to stay healthy", false, "Health", "Most people can get all necessary nutrients from a balanced whole-food diet."),
            Question(9, "Stretching prevents all injuries", false, "Health", "While it improves flexibility, it cannot prevent injuries caused by impact or overexertion."),
            Question(10, "Skipping meals is a healthy way to lose weight", false, "Health", "This can slow metabolism and lead to overeating later in the day."),

            // CLEANING (TRUE)
            Question(11, "Baking soda in the fridge absorbs odour", true, "Cleaning", "Its alkaline nature neutralizes acidic odor molecules in the air."),
            Question(12, "Hot water cleans better than cold water", true, "Cleaning", "Heat helps break down fats and oils more effectively than cold water."),
            Question(13, "Cleaning a little daily reduces deep cleaning", true, "Cleaning", "Frequent maintenance prevents the buildup of grime that requires heavy scrubbing."),
            Question(14, "Air-drying clothes reduces electricity cost", true, "Cleaning", "Using a clothesline utilizes natural energy instead of expensive dryer electricity."),
            Question(15, "Reusable cloths save money over time", true, "Cleaning", "Investing in washable cloths eliminates the recurring cost of disposable paper towels."),

            // CLEANING (FALSE)
            Question(16, "Coca-Cola cleans greasy floors better than soap", false, "Cleaning", "The high sugar content in soda creates a sticky residue that attracts more dirt."),
            Question(17, "Cleaning and disinfecting are the same", false, "Cleaning", "Cleaning removes visible dirt, while disinfecting uses chemicals to actually kill germs."),
            Question(18, "Making your bed has no effect on cleanliness", false, "Cleaning", "It sets a productive tone for the day and reduces the surface area for dust to collect."),
            Question(19, "Mixing cleaning products makes them better", false, "Cleaning", "Mixing chemicals like bleach and ammonia can create toxic, life-threatening gases."),
            Question(20, "Newspaper is best for cleaning windows", false, "Cleaning", "Modern ink can smear onto frames, and microfiber cloths are more effective and lint-free."),

            // PRODUCTIVITY (TRUE)
            Question(21, "Pomodoro technique helps focus", true, "Productivity", "Breaking work into timed intervals maintains high focus and prevents mental fatigue."),
            Question(22, "Structured routines improve time management", true, "Productivity", "Habits reduce \"decision fatigue,\" allowing you to save mental energy for important tasks."),
            Question(23, "Budget tracking avoids unnecessary spending", true, "Productivity", "Visualizing expenses highlights leaks in your spending habits."),
            Question(24, "To-do lists help you stay organized", true, "Productivity", "Writing tasks down offloads them from your memory, reducing anxiety."),
            Question(25, "Tracking progress improves productivity", true, "Productivity", "Seeing small wins provides the dopamine hit needed to stay motivated."),

            // PRODUCTIVITY (FALSE)
            Question(26, "Drinking coffee all day keeps you productive", false, "Productivity", "Excessive caffeine leads to energy crashes and jitters that hurt concentration."),
            Question(27, "Procrastination improves work quality", false, "Productivity", "Rushing at the last minute increases errors and limits time for thorough review."),
            Question(28, "Buying on sale always saves money", false, "Productivity", "Buying something you don't need just because it's \"cheap\" is still an unnecessary expense."),
            Question(29, "Waking early guarantees productivity", false, "Productivity", "Productivity depends on how you use your time, not just the hour you wake up."),
            Question(30, "Being busy means being productive", false, "Productivity", "Business is often just \"active laziness\" if you aren't focused on high-impact tasks.")
        )
    }
}
