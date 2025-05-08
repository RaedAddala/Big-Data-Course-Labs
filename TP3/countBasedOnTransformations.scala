// use transformations
val docs = sc.textFile("file1.txt")
val lower = docs.map(line => line.toLowerCase)
val words = lower.flatMap(line => line.split("\\s+"))
val counts = words.map(word => (word,1))
val freq = counts.reduceByKey(_ + _)
freq.map(_.swap)
val top = freq.map(_.swap).top(3)
