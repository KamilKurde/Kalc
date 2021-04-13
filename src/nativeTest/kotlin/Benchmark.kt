import com.github.KamilKurde.Kalc.*
import kotlin.random.Random
import kotlin.system.getTimeMillis
import kotlin.test.Test

class Benchmark
{
	enum class UnitTypes
	{
		Distance,
		Area,
		Volume,
		Speed,
		Time
	}

	@Test
	fun overallSpeedTest()
	{
		benchmark(
			100_000,
			UnitTypes.Distance,
			UnitTypes.Area,
			UnitTypes.Volume,
			UnitTypes.Speed,
			UnitTypes.Time,
		)
	}

	private fun currentTime() = Time(getTimeMillis(), TimeUnits.Milliseconds)

	private fun distanceBenchmark(size: Int): Time
	{
		val data = Array(size) { Random.nextDouble().meters }
		val unitsValues = DistanceUnits.values()
		val units = Array(size) { unitsValues.random() }
		val startingTime = currentTime()
		val processedData = Array(size) { Distance(data[it].inMeters, units[it]) }
		val processingTime = currentTime() - startingTime
		val sampleSeed = (0 until size).random()
		println("	Sample of processedData: ${processedData[sampleSeed].inMeters.toStringExpanded()}")
		return processingTime
	}

	private fun areaBenchmark(size: Int): Time
	{
		val data = Array(size) { Random.nextDouble().meters2 }
		val unitsValues = AreaUnits.values()
		val units = Array(size) { unitsValues.random() }
		val startingTime = currentTime()
		val processedData = Array(size) { Area(data[it].inMeters2, units[it]) }
		val processingTime = currentTime() - startingTime
		val sampleSeed = (0 until size).random()
		println("	Sample of processedData: ${processedData[sampleSeed].inMeters2.toStringExpanded()}")
		return processingTime
	}

	private fun volumeBenchmark(size: Int): Time
	{
		val data = Array(size) { Random.nextDouble().meters3 }
		val unitsValues = VolumeUnits.values()
		val units = Array(size) { unitsValues.random() }
		val startingTime = currentTime()
		val processedData = Array(size) { Volume(data[it].inMeters3, units[it]) }
		val processingTime = currentTime() - startingTime
		val sampleSeed = (0 until size).random()
		println("	Sample of processedData: ${processedData[sampleSeed].inMeters3.toStringExpanded()}")
		return processingTime
	}

	private fun speedBenchmark(size: Int): Time
	{
		val data = Array(size) { Random.nextDouble().metersPerSecond }
		val unitsValues = SpeedUnits.values()
		val units = Array(size) { unitsValues.random() }
		val startingTime = currentTime()
		val processedData = Array(size) { Speed(data[it].inMetersPerSecond, units[it]) }
		val processingTime = currentTime() - startingTime
		val sampleSeed = (0 until size).random()
		println("	Sample of processedData: ${processedData[sampleSeed].inMetersPerSecond.toStringExpanded()}")
		return processingTime
	}

	private fun timeBenchmark(size: Int): Time
	{
		val data = Array(size) { Random.nextDouble().seconds }
		val unitsValues = TimeUnits.values()
		val units = Array(size) { unitsValues.random() }
		val startingTime = currentTime()
		val processedData = Array(size) { Time(data[it].inSeconds, units[it]) }
		val processingTime = currentTime() - startingTime
		val sampleSeed = (0 until size).random()
		println("	Sample of processedData: ${processedData[sampleSeed].inSeconds.toStringExpanded()}")
		return processingTime
	}

	fun benchmark(size: Int, vararg units: UnitTypes)
	{
		for (unit in units)
		{
			println("Processing $size samples of $unit: ")
			val time = when (unit)
			{
				UnitTypes.Distance -> distanceBenchmark(size)
				UnitTypes.Area     -> areaBenchmark(size)
				UnitTypes.Volume   -> volumeBenchmark(size)
				UnitTypes.Speed    -> speedBenchmark(size)
				UnitTypes.Time     -> timeBenchmark(size)
			}
			println("	Processed $size $unit conversions:")
			println("	${time.inMilliseconds.toStringExpanded()} ms,")
			println("	${size.toDouble() / time.inSeconds.toString().toDouble()} OPS")
		}
	}
}