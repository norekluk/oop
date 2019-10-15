object Lab1 extends App{
  println("hello world")
  //val x = if(cond)

  class Car(val year: Int, var mileage: Int = 0){

    def drive(distance: Int): Unit ={
      mileage += distance
    }
  }

  object Car{
    val defaultMilaege = 0

    def apply(year: Int, mileage: Int = 0): Car = {
      if (year < 1000)
        throw new IllegalArgumentException("year myust be greater than 1000")
      new Car(year, defaultMilaege)
    }
  }
  val c = Car(2015) // Car.apply(2015)
  val car = new Car(2000)

  println(car.year)
  println(car.mileage)

  val cars = List(new Car(2000, 10), new Car(2010,20))

  for (car <- cars){
    print(car.year)
    print("->")
    println(car.mileage)
  }

  def totalMileage(cars : List[Car], f: Car => Boolean) : Int = {
//    var total = 0
//    for (car <- cars)
//      if(filter(car))
//        total += car.mileage
//    total
    cars.filter(f).map(car => car.mileage).sum
  }

  println(totalMileage(cars, car => car.year > 2005))
}
