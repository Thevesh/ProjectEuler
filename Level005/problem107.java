
public class problem107 {

	public static void main(String[] args) {

		double start = System.nanoTime();
		
		int sumI = 0; // Total weight of all arcs. Remember to divide by 2. The table is a mirror image along its diagonal.
		
		for (int i = 0; i < Table.length; i++){
			for (int j = 0; j < Table.length; j++){
				if (Table[i][j] != Integer.MAX_VALUE) sumI += Table[i][j];
			}
		}
			
		int initial = 0; 				// Initial row.
		int target = Table.length - 1; 	// Target number of arcs, equal to (nodes - 1).
		int count = 0; 					// Number of arcs added so far.
		int weight = 0; 				// Total weight of MST.
		
		int check = Integer.MAX_VALUE; 	// Weight of the newest minimum arc.
		int newRow = 0; 				// Latest row to check.
		
		int[] nodes = new int[Table.length]; // Array of all nodes to check.
		nodes[0] = initial;                  // Set first node to row with minimum value.
		int toAdd = 1;                       // Position of next node to be added to list of nodes to check.
		
		// Set all nodes apart from first one to max value to limit search. Values will be updated during Prim's.
		for (int n = 1; n < nodes.length; n++){
			nodes[n] = Integer.MAX_VALUE;
		}
		
		// Cancel all values in initial column.		
		for (int i = 0; i < Table.length; i++){
			Table[i][initial] = Integer.MAX_VALUE;
		}
		
		// Now, run Prim's on a table.		
		while (count < target){
			
			for (int j = 0; j < nodes.length; j++){
				if (nodes[j] == Integer.MAX_VALUE) break; // We constructed the array so all relevant row numbers come before the first MAaxValue.
				int[] arr = ArrayMin(Table[nodes[j]]);
				if (arr[0] < check){
					check = arr[0];
					newRow = arr[1];
				}
			}
			
			nodes[toAdd] = newRow; 	// Add the new relevant row to the array of nodes.
			toAdd ++;				// Increment the position value of the next node.

			weight += check;
			check = Integer.MAX_VALUE; // Reset check value for next iteration of the While loop.
			
			// Set all values in the column of the node we just added to MaxValue. This ensures an already connected node is not added again.
			for (int i = 0; i < Table.length; i++){
				Table[i][newRow] = Integer.MAX_VALUE;  
			}
			

			count++;
		}
		
		// MST formed.

		System.out.println("Total weight of " + sumI/2);
		System.out.println("MST has weight of " + weight);
		System.out.println("Algorithm saves " + (sumI/2 - weight));
		double duration = (System.nanoTime() - start) / 1000000000;
		System.out.println("Your code took " + duration + " seconds to execute.");

	}
	
	public static int[] ArrayMin (int[] arr){
		int check = Integer.MAX_VALUE;
		int row = 0;
		
		for (int j = 0; j < arr.length; j++){
			if (arr[j] != Integer.MAX_VALUE && arr[j] < check){
				check = arr[j];
				row= j;
			}
		}
		
		int result[] = new int[2];
		result[0] = check;
		result[1] = row;
		
		return result;
	}
	
	public static int[][] Table = {
			{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,427,668,495,377,678,Integer.MAX_VALUE,177,Integer.MAX_VALUE,Integer.MAX_VALUE,870,Integer.MAX_VALUE,869,624,300,609,131,Integer.MAX_VALUE,251,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,856,221,514,Integer.MAX_VALUE,591,762,182,56,Integer.MAX_VALUE,884,412,273,636,Integer.MAX_VALUE,Integer.MAX_VALUE,774},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,262,Integer.MAX_VALUE,Integer.MAX_VALUE,508,472,799,Integer.MAX_VALUE,956,578,363,940,143,Integer.MAX_VALUE,162,122,910,Integer.MAX_VALUE,729,802,941,922,573,531,539,667,607,Integer.MAX_VALUE,920,Integer.MAX_VALUE,Integer.MAX_VALUE,315,649,937,Integer.MAX_VALUE,185,102,636,289},
			{Integer.MAX_VALUE,262,Integer.MAX_VALUE,Integer.MAX_VALUE,926,Integer.MAX_VALUE,958,158,647,47,621,264,81,Integer.MAX_VALUE,402,813,649,386,252,391,264,637,349,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,108,Integer.MAX_VALUE,727,225,578,699,Integer.MAX_VALUE,898,294,Integer.MAX_VALUE,575,168,432,833},
			{427,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,366,Integer.MAX_VALUE,Integer.MAX_VALUE,635,Integer.MAX_VALUE,32,962,468,893,854,718,427,448,916,258,Integer.MAX_VALUE,760,909,529,311,404,Integer.MAX_VALUE,Integer.MAX_VALUE,588,680,875,Integer.MAX_VALUE,615,Integer.MAX_VALUE,409,758,221,Integer.MAX_VALUE,Integer.MAX_VALUE,76,257},
			{668,Integer.MAX_VALUE,926,366,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,250,268,Integer.MAX_VALUE,503,944,Integer.MAX_VALUE,677,Integer.MAX_VALUE,727,793,457,981,191,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,351,969,925,987,328,282,589,Integer.MAX_VALUE,873,477,Integer.MAX_VALUE,Integer.MAX_VALUE,19,450,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{495,508,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,765,711,819,305,302,926,Integer.MAX_VALUE,Integer.MAX_VALUE,582,Integer.MAX_VALUE,861,Integer.MAX_VALUE,683,293,Integer.MAX_VALUE,Integer.MAX_VALUE,66,Integer.MAX_VALUE,27,Integer.MAX_VALUE,Integer.MAX_VALUE,290,Integer.MAX_VALUE,786,Integer.MAX_VALUE,554,817,33,Integer.MAX_VALUE,54,506,386,381},
			{377,472,958,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,120,42,Integer.MAX_VALUE,134,219,457,639,538,374,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,966,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,449,120,797,358,232,550,Integer.MAX_VALUE,305,997,662,744,686,239},
			{678,799,158,635,250,765,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,35,Integer.MAX_VALUE,106,385,652,160,Integer.MAX_VALUE,890,812,605,953,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,79,Integer.MAX_VALUE,712,613,312,452,Integer.MAX_VALUE,978,900,Integer.MAX_VALUE,901,Integer.MAX_VALUE,Integer.MAX_VALUE,225,533,770,722},
			{Integer.MAX_VALUE,Integer.MAX_VALUE,647,Integer.MAX_VALUE,268,711,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,283,Integer.MAX_VALUE,172,Integer.MAX_VALUE,663,236,36,403,286,986,Integer.MAX_VALUE,Integer.MAX_VALUE,810,761,574,53,793,Integer.MAX_VALUE,Integer.MAX_VALUE,777,330,936,883,286,Integer.MAX_VALUE,174,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,828,711},
			{177,956,47,32,Integer.MAX_VALUE,819,120,35,283,Integer.MAX_VALUE,50,Integer.MAX_VALUE,565,36,767,684,344,489,565,Integer.MAX_VALUE,Integer.MAX_VALUE,103,810,463,733,665,494,644,863,25,385,Integer.MAX_VALUE,342,470,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,730,582,468},
			{Integer.MAX_VALUE,578,621,962,503,305,42,Integer.MAX_VALUE,Integer.MAX_VALUE,50,Integer.MAX_VALUE,155,519,Integer.MAX_VALUE,Integer.MAX_VALUE,256,990,801,154,53,474,650,402,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,966,Integer.MAX_VALUE,Integer.MAX_VALUE,406,989,772,932,7,Integer.MAX_VALUE,823,391,Integer.MAX_VALUE,Integer.MAX_VALUE,933},
			{Integer.MAX_VALUE,363,264,468,944,302,Integer.MAX_VALUE,106,172,Integer.MAX_VALUE,155,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,380,438,Integer.MAX_VALUE,41,266,Integer.MAX_VALUE,Integer.MAX_VALUE,104,867,609,Integer.MAX_VALUE,270,861,Integer.MAX_VALUE,Integer.MAX_VALUE,165,Integer.MAX_VALUE,675,250,686,995,366,191,Integer.MAX_VALUE,433,Integer.MAX_VALUE},
			{870,940,81,893,Integer.MAX_VALUE,926,134,385,Integer.MAX_VALUE,565,519,Integer.MAX_VALUE,Integer.MAX_VALUE,313,851,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,248,220,Integer.MAX_VALUE,826,359,829,Integer.MAX_VALUE,234,198,145,409,68,359,Integer.MAX_VALUE,814,218,186,Integer.MAX_VALUE,Integer.MAX_VALUE,929,203,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,143,Integer.MAX_VALUE,854,677,Integer.MAX_VALUE,219,652,663,36,Integer.MAX_VALUE,Integer.MAX_VALUE,313,Integer.MAX_VALUE,132,Integer.MAX_VALUE,433,598,Integer.MAX_VALUE,Integer.MAX_VALUE,168,870,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,128,437,Integer.MAX_VALUE,383,364,966,227,Integer.MAX_VALUE,Integer.MAX_VALUE,807,993,Integer.MAX_VALUE,Integer.MAX_VALUE,526,17},
			{869,Integer.MAX_VALUE,402,718,Integer.MAX_VALUE,Integer.MAX_VALUE,457,160,236,767,Integer.MAX_VALUE,380,851,132,Integer.MAX_VALUE,Integer.MAX_VALUE,596,903,613,730,Integer.MAX_VALUE,261,Integer.MAX_VALUE,142,379,885,89,Integer.MAX_VALUE,848,258,112,Integer.MAX_VALUE,900,Integer.MAX_VALUE,Integer.MAX_VALUE,818,639,268,600,Integer.MAX_VALUE},
			{624,162,813,427,727,582,639,Integer.MAX_VALUE,36,684,256,438,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,539,379,664,561,542,Integer.MAX_VALUE,999,585,Integer.MAX_VALUE,Integer.MAX_VALUE,321,398,Integer.MAX_VALUE,Integer.MAX_VALUE,950,68,193,Integer.MAX_VALUE,697,Integer.MAX_VALUE,390,588,848,Integer.MAX_VALUE},
			{300,122,649,448,793,Integer.MAX_VALUE,538,890,403,344,990,Integer.MAX_VALUE,Integer.MAX_VALUE,433,596,539,Integer.MAX_VALUE,Integer.MAX_VALUE,73,Integer.MAX_VALUE,318,Integer.MAX_VALUE,Integer.MAX_VALUE,500,Integer.MAX_VALUE,968,Integer.MAX_VALUE,291,Integer.MAX_VALUE,Integer.MAX_VALUE,765,196,504,757,Integer.MAX_VALUE,542,Integer.MAX_VALUE,395,227,148},
			{609,910,386,916,457,861,374,812,286,489,801,41,Integer.MAX_VALUE,598,903,379,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,946,136,399,Integer.MAX_VALUE,941,707,156,757,258,251,Integer.MAX_VALUE,807,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,461,501,Integer.MAX_VALUE,Integer.MAX_VALUE,616,Integer.MAX_VALUE},
			{131,Integer.MAX_VALUE,252,258,981,Integer.MAX_VALUE,Integer.MAX_VALUE,605,986,565,154,266,248,Integer.MAX_VALUE,613,664,73,Integer.MAX_VALUE,Integer.MAX_VALUE,686,Integer.MAX_VALUE,Integer.MAX_VALUE,575,627,817,282,Integer.MAX_VALUE,698,398,222,Integer.MAX_VALUE,649,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,654,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,729,391,Integer.MAX_VALUE,191,683,Integer.MAX_VALUE,953,Integer.MAX_VALUE,Integer.MAX_VALUE,53,Integer.MAX_VALUE,220,Integer.MAX_VALUE,730,561,Integer.MAX_VALUE,946,686,Integer.MAX_VALUE,Integer.MAX_VALUE,389,729,553,304,703,455,857,260,Integer.MAX_VALUE,991,182,351,477,867,Integer.MAX_VALUE,Integer.MAX_VALUE,889,217,853},
			{251,802,264,760,Integer.MAX_VALUE,293,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,474,Integer.MAX_VALUE,Integer.MAX_VALUE,168,Integer.MAX_VALUE,542,318,136,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,392,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,267,407,27,651,80,927,Integer.MAX_VALUE,974,977,Integer.MAX_VALUE,Integer.MAX_VALUE,457,117,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,941,637,909,Integer.MAX_VALUE,Integer.MAX_VALUE,966,Integer.MAX_VALUE,810,103,650,104,826,870,261,Integer.MAX_VALUE,Integer.MAX_VALUE,399,Integer.MAX_VALUE,389,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,202,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,867,140,403,962,785,Integer.MAX_VALUE,511,Integer.MAX_VALUE,1,Integer.MAX_VALUE,707,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,922,349,529,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,761,810,402,867,359,Integer.MAX_VALUE,Integer.MAX_VALUE,999,Integer.MAX_VALUE,Integer.MAX_VALUE,575,729,392,Integer.MAX_VALUE,Integer.MAX_VALUE,388,939,Integer.MAX_VALUE,959,Integer.MAX_VALUE,83,463,361,Integer.MAX_VALUE,Integer.MAX_VALUE,512,931,Integer.MAX_VALUE,224,690,369,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,573,Integer.MAX_VALUE,311,351,66,Integer.MAX_VALUE,79,574,463,Integer.MAX_VALUE,609,829,Integer.MAX_VALUE,142,585,500,941,627,553,Integer.MAX_VALUE,202,388,Integer.MAX_VALUE,164,829,Integer.MAX_VALUE,620,523,639,936,Integer.MAX_VALUE,Integer.MAX_VALUE,490,Integer.MAX_VALUE,695,Integer.MAX_VALUE,505,109,Integer.MAX_VALUE},
			{856,531,Integer.MAX_VALUE,404,969,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,53,733,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,379,Integer.MAX_VALUE,Integer.MAX_VALUE,707,817,304,Integer.MAX_VALUE,Integer.MAX_VALUE,939,164,Integer.MAX_VALUE,Integer.MAX_VALUE,616,716,728,Integer.MAX_VALUE,889,349,Integer.MAX_VALUE,963,150,447,Integer.MAX_VALUE,292,586,264},
			{221,539,Integer.MAX_VALUE,Integer.MAX_VALUE,925,27,Integer.MAX_VALUE,712,793,665,Integer.MAX_VALUE,270,234,128,885,Integer.MAX_VALUE,968,156,282,703,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,829,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,822,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,736,576,Integer.MAX_VALUE,697,946,443,Integer.MAX_VALUE,205,194},
			{514,667,108,Integer.MAX_VALUE,987,Integer.MAX_VALUE,Integer.MAX_VALUE,613,Integer.MAX_VALUE,494,966,861,198,437,89,321,Integer.MAX_VALUE,757,Integer.MAX_VALUE,455,267,Integer.MAX_VALUE,959,Integer.MAX_VALUE,616,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,349,156,339,Integer.MAX_VALUE,102,790,359,Integer.MAX_VALUE,439,938,809,260},
			{Integer.MAX_VALUE,607,Integer.MAX_VALUE,588,328,Integer.MAX_VALUE,449,312,Integer.MAX_VALUE,644,Integer.MAX_VALUE,Integer.MAX_VALUE,145,Integer.MAX_VALUE,Integer.MAX_VALUE,398,291,258,698,857,407,Integer.MAX_VALUE,Integer.MAX_VALUE,620,716,822,Integer.MAX_VALUE,Integer.MAX_VALUE,293,486,943,Integer.MAX_VALUE,779,Integer.MAX_VALUE,6,880,116,775,Integer.MAX_VALUE,947},
			{591,Integer.MAX_VALUE,727,680,282,290,120,452,777,863,Integer.MAX_VALUE,Integer.MAX_VALUE,409,383,848,Integer.MAX_VALUE,Integer.MAX_VALUE,251,398,260,27,867,83,523,728,Integer.MAX_VALUE,349,293,Integer.MAX_VALUE,212,684,505,341,384,9,992,507,48,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{762,920,225,875,589,Integer.MAX_VALUE,797,Integer.MAX_VALUE,330,25,406,165,68,364,258,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,222,Integer.MAX_VALUE,651,140,463,639,Integer.MAX_VALUE,Integer.MAX_VALUE,156,486,212,Integer.MAX_VALUE,Integer.MAX_VALUE,349,723,Integer.MAX_VALUE,Integer.MAX_VALUE,186,Integer.MAX_VALUE,36,240,752},
			{182,Integer.MAX_VALUE,578,Integer.MAX_VALUE,Integer.MAX_VALUE,786,358,978,936,385,989,Integer.MAX_VALUE,359,966,112,950,765,807,Integer.MAX_VALUE,991,80,403,361,936,889,Integer.MAX_VALUE,339,943,684,Integer.MAX_VALUE,Integer.MAX_VALUE,965,302,676,725,Integer.MAX_VALUE,327,134,Integer.MAX_VALUE,147},
			{56,Integer.MAX_VALUE,699,615,873,Integer.MAX_VALUE,232,900,883,Integer.MAX_VALUE,772,675,Integer.MAX_VALUE,227,Integer.MAX_VALUE,68,196,Integer.MAX_VALUE,649,182,927,962,Integer.MAX_VALUE,Integer.MAX_VALUE,349,736,Integer.MAX_VALUE,Integer.MAX_VALUE,505,349,965,Integer.MAX_VALUE,474,178,833,Integer.MAX_VALUE,Integer.MAX_VALUE,555,853,Integer.MAX_VALUE},
			{Integer.MAX_VALUE,315,Integer.MAX_VALUE,Integer.MAX_VALUE,477,554,550,Integer.MAX_VALUE,286,342,932,250,814,Integer.MAX_VALUE,900,193,504,Integer.MAX_VALUE,Integer.MAX_VALUE,351,Integer.MAX_VALUE,785,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,576,102,779,341,723,302,474,Integer.MAX_VALUE,689,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,451,Integer.MAX_VALUE,Integer.MAX_VALUE},
			{884,649,898,409,Integer.MAX_VALUE,817,Integer.MAX_VALUE,901,Integer.MAX_VALUE,470,7,686,218,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,757,Integer.MAX_VALUE,Integer.MAX_VALUE,477,974,Integer.MAX_VALUE,512,490,963,Integer.MAX_VALUE,790,Integer.MAX_VALUE,384,Integer.MAX_VALUE,676,178,689,Integer.MAX_VALUE,245,596,445,Integer.MAX_VALUE,Integer.MAX_VALUE,343},
			{412,937,294,758,Integer.MAX_VALUE,33,305,Integer.MAX_VALUE,174,Integer.MAX_VALUE,Integer.MAX_VALUE,995,186,807,Integer.MAX_VALUE,697,Integer.MAX_VALUE,461,Integer.MAX_VALUE,867,977,511,931,Integer.MAX_VALUE,150,697,359,6,9,Integer.MAX_VALUE,725,833,Integer.MAX_VALUE,245,Integer.MAX_VALUE,949,Integer.MAX_VALUE,270,Integer.MAX_VALUE,112},
			{273,Integer.MAX_VALUE,Integer.MAX_VALUE,221,19,Integer.MAX_VALUE,997,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,823,366,Integer.MAX_VALUE,993,818,Integer.MAX_VALUE,542,501,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,695,447,946,Integer.MAX_VALUE,880,992,186,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,596,949,Integer.MAX_VALUE,91,Integer.MAX_VALUE,768,273},
			{636,185,575,Integer.MAX_VALUE,450,54,662,225,Integer.MAX_VALUE,Integer.MAX_VALUE,391,191,Integer.MAX_VALUE,Integer.MAX_VALUE,639,390,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,224,Integer.MAX_VALUE,Integer.MAX_VALUE,443,439,116,507,Integer.MAX_VALUE,327,Integer.MAX_VALUE,Integer.MAX_VALUE,445,Integer.MAX_VALUE,91,Integer.MAX_VALUE,248,Integer.MAX_VALUE,344},
			{Integer.MAX_VALUE,102,168,Integer.MAX_VALUE,Integer.MAX_VALUE,506,744,533,Integer.MAX_VALUE,730,Integer.MAX_VALUE,Integer.MAX_VALUE,929,Integer.MAX_VALUE,268,588,395,Integer.MAX_VALUE,654,889,457,Integer.MAX_VALUE,690,505,292,Integer.MAX_VALUE,938,775,48,36,134,555,451,Integer.MAX_VALUE,270,Integer.MAX_VALUE,248,Integer.MAX_VALUE,371,680},
			{Integer.MAX_VALUE,636,432,76,Integer.MAX_VALUE,386,686,770,828,582,Integer.MAX_VALUE,433,203,526,600,848,227,616,Integer.MAX_VALUE,217,117,707,369,109,586,205,809,Integer.MAX_VALUE,Integer.MAX_VALUE,240,Integer.MAX_VALUE,853,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,768,Integer.MAX_VALUE,371,Integer.MAX_VALUE,540},
			{774,289,833,257,Integer.MAX_VALUE,381,239,722,711,468,933,Integer.MAX_VALUE,Integer.MAX_VALUE,17,Integer.MAX_VALUE,Integer.MAX_VALUE,148,Integer.MAX_VALUE,Integer.MAX_VALUE,853,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,264,194,260,947,Integer.MAX_VALUE,752,147,Integer.MAX_VALUE,Integer.MAX_VALUE,343,112,273,344,680,540,Integer.MAX_VALUE}
		};

	
}
