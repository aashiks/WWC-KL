val files = new java.io.File(".").listFiles

for(file <- files){
    val fileName = file.getName
    if(fileName.endsWith("scala")) println(file)
}


/*
// Guard clauses
for(
  file <- files;
  if(file.getName.endsWith("scala"))
) println(file)


 */
// yielding

val fileNames = for(
  file <- files;
  if(file.getName.endsWith("scala"))
    ) yield file.getName
/*
for(n <- fileNames) println(" X " + n)


 */

// Getting more FUNKY
val aList = List(1,2,3)
val bList = List(4,5,6)

for{ a <- aList; b <- bList} println(a+b)
