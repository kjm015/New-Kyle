package io.github.kjm015.kylenewer.util

import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class SpamService {

    private val names = arrayListOf(
        "Doland",
        "Bobert",
        "Bilbert",
        "Staniel",
        "Stanthony",
        "Fredward",
        "Samford",
        "Harriston",
        "Bimmy",
        "Williard",
        "Billiard",
        "Philliam",
        "Ronford",
        "Gilliam",
        "Jimbert",
        "Quintony",
        "Roward",
        "Jimby",
        "Herek",
        "Bevin"
    )
    private val positions = arrayListOf("President", "CEO", "Head", "Inventor", "Leader")
    private val companies = arrayListOf(
        "Apple",
        "Rolex",
        "Microsoft",
        "Google",
        "Mastercard",
        "the UN",
        " the IRS",
        "Harvard",
        "Samsung",
        "Dell",
        "Visa",
        "Facebook",
        "Twitter",
        "Toyota"
    )
    private val legitNames = arrayListOf(
        "Paul",
        "Rob",
        "Stan",
        "Mike",
        "Ron",
        "Mark",
        "Kevin",
        "Dan",
        "Todd",
        "Howard",
        "Carl",
        "Phil",
        "John",
        "Steve",
        "Randy",
        "Fred",
        "James",
        "Jack",
        "Earl",
        "Sam",
        "Bill",
        "Kyle",
        "Tim",
        "Tom",
        "Niel",
        "Jake",
        "Roy",
        "Vance",
        "Don",
        "Peter",
        "Pat",
        "Doug",
        "Derek",
        "Keith",
        "Chris"
    )
    private val legitCities = arrayListOf(
        "Accra",
        "Lome",
        "Chennai",
        "Kolkata",
        "Mumbai",
        "Dhaka",
        "Hyderabad",
        "Delhi",
        "Karachi",
        "Ahmedabad",
        "Bhubaneswar",
        "Panaji",
        "Dehradun",
        "Lahore",
        "Pune",
        "Bangalore",
        "Lucknow",
        "Bhopal",
        "Visakhapatnam",
        "Srinagar"
    )
    private val streets = arrayListOf(
        "Street",
        "Avenue",
        "Way",
        "Boulevard",
        "Highway",
        "Court",
        "Path",
        "Drive",
        "Parkway",
        "Lane"
    )
    private val information = arrayListOf(
        "credit card number",
        "social security number",
        "phone number",
        "date of birth",
        "home address",
        "mother's maiden name",
        "bank routing number",
        "email address",
        "Facebook password",
        "Twitter password",
        "bank PIN"
    )
    private val methodsOfExchange = arrayListOf(
        "Steam gift cards",
        "Bitcoin",
        "Ethereum",
        "cash",
        "prepaid gift cards",
        "wire transfer",
        "Venmo",
        "PayPal",
        "CashApp",
        "direct deposit"
    )

    fun scamMessage(): String = scamTemplates().random()

    private fun scamTemplates(): ArrayList<String> {
        val tempList = arrayListOf<String>()

        tempList.addAll(streets)
        tempList.addAll(legitCities)
        tempList.addAll(legitNames)

        return arrayListOf(
            """
            Dear ${names.random()},
                
            I am the ${positions.random()} of ${companies.random()}. You are eligible for a $${
                Random.nextInt(
                    from = 10000,
                    until = 1000000
                )
            } prize.
                
            In order to receive your prize, you must send your ${information.random()} and $${
                Random.nextInt(
                    from = 250,
                    until = 1000
                )
            } in ${methodsOfExchange.random()}
            to ${Random.nextInt(100, 9999)} ${tempList.random()} ${streets.random()} in ${legitCities.random()}. You will receive your prize within ${Random.nextInt(3,10)} days.
                
            Best wishes, 
            ${legitNames.random()} ${legitNames.random()}
            """.trim()
        )
    }
}