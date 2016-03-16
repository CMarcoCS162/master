public class TableLookup {

	// Magic code is more pleasant than actually looking up info in a table
	public static int[] getAlignmentCoords(int version) { 
		if (version <= 1) {
			return new int[0];
		}

		int num = (version / 7) + 2;// number of coordinates to return
		int[] result = new int[num];

		result[0] = 6;

		if (num == 1) {
			return result;
		}

		result[num - 1] = 4 * version + 10;

		if (num == 2) {
			return result;
		}

		result[num - 2] = 2 * ((result[0] + result[num - 1] * (num - 2)) / ((num - 1) * 2));
		if (num == 3) {
			return result;
		}

		int step = result[num - 1] - result[num - 2];

		for (int i = num - 3; i > 0; i--) {
			result[i] = result[i + 1] - step;
		}

		return result;
	}

	public static int fromAlpha(int i) {
		int[] list = {1, 2, 4, 8, 16, 32, 64, 128, 29, 58, 116, 232, 205, 135, 19, 38, 76, 152, 45, 90, 180, 117, 234, 201, 143, 3, 6, 12, 24, 48, 96, 192, 157, 39, 78, 156, 37, 74, 148, 53, 106, 212, 181, 119, 238, 193, 159, 35, 70, 140, 5, 10, 20, 40, 80, 160, 93, 186, 105, 210, 185, 111, 222, 161, 95, 190, 97, 194, 153, 47, 94, 188, 101, 202, 137, 15, 30, 60, 120, 240, 253, 231, 211, 187, 107, 214, 177, 127, 254, 225, 223, 163, 91, 182, 113, 226, 217, 175, 67, 134, 17, 34, 68, 136, 13, 26, 52, 104, 208, 189, 103, 206, 129, 31, 62, 124, 248, 237, 199, 147, 59, 118, 236, 197, 151, 51, 102, 204, 133, 23, 46, 92, 184, 109, 218, 169, 79, 158, 33, 66, 132, 21, 42, 84, 168, 77, 154, 41, 82, 164, 85, 170, 73, 146, 57, 114, 228, 213, 183, 115, 230, 209, 191, 99, 198, 145, 63, 126, 252, 229, 215, 179, 123, 246, 241, 255, 227, 219, 171, 75, 150, 49, 98, 196, 149, 55, 110, 220, 165, 87, 174, 65, 130, 25, 50, 100, 200, 141, 7, 14, 28, 56, 112, 224, 221, 167, 83, 166, 81, 162, 89, 178, 121, 242, 249, 239, 195, 155, 43, 86, 172, 69, 138, 9, 18, 36, 72, 144, 61, 122, 244, 245, 247, 243, 251, 235, 203, 139, 11, 22, 44, 88, 176, 125, 250, 233, 207, 131, 27, 54, 108, 216, 173, 71, 142, 1};
		return list[i];
	}

	public static int toAlpha(int i) {
		int[] list = {0, 0 , 1 , 25 , 2 , 50 , 26 , 198 , 3 , 223 , 51 , 238 , 27 , 104 , 199 , 75 , 4 , 100 , 224 , 14 , 52 , 141 , 239 , 129 , 28 , 193 , 105 , 248 , 200 , 8 , 76 , 113 , 5 , 138 , 101 , 47 , 225 , 36 , 15 , 33 , 53 , 147 , 142 , 218 , 240 , 18 , 130 , 69 , 29 , 181 , 194 , 125 , 106 , 39 , 249 , 185 , 201 , 154 , 9 , 120 , 77 , 228 , 114 , 166 , 6 , 191 , 139 , 98 , 102 , 221 , 48 , 253 , 226 , 152 , 37 , 179 , 16 , 145 , 34 , 136 , 54 , 208 , 148 , 206 , 143 , 150 , 219 , 189 , 241 , 210 , 19 , 92 , 131 , 56 , 70 , 64 , 30 , 66 , 182 , 163 , 195 , 72 , 126 , 110 , 107 , 58 , 40 , 84 , 250 , 133 , 186 , 61 , 202 , 94 , 155 , 159 , 10 , 21 , 121 , 43 , 78 , 212 , 229 , 172 , 115 , 243 , 167 , 87 , 7 , 112 , 192 , 247 , 140 , 128 , 99 , 13 , 103 , 74 , 222 , 237 , 49 , 197 , 254 , 24 , 227 , 165 , 153 , 119 , 38 , 184 , 180 , 124 , 17 , 68 , 146 , 217 , 35 , 32 , 137 , 46 , 55 , 63 , 209 , 91 , 149 , 188 , 207 , 205 , 144 , 135 , 151 , 178 , 220 , 252 , 190 , 97 , 242 , 86 , 211 , 171 , 20 , 42 , 93 , 158 , 132 , 60 , 57 , 83 , 71 , 109 , 65 , 162 , 31 , 45 , 67 , 216 , 183 , 123 , 164 , 118 , 196 , 23 , 73 , 236 , 127 , 12 , 111 , 246 , 108 , 161 , 59 , 82 , 41 , 157 , 85 , 170 , 251 , 96 , 134 , 177 , 187 , 204 , 62 , 90 , 203 , 89 , 95 , 176 , 156 , 169 , 160 , 81 , 11 , 245 , 22 , 235 , 122 , 117 , 44 , 215 , 79 , 174 , 213 , 233 , 230 , 231 , 173 , 232 , 116 , 214 , 244 , 234 , 168 , 80 , 88 , 175};
		return list[i];
	}

	public static int maxCapacity(int ver, int lvl, int enc) {
		int[][] temp = {{41, 25, 17, 10}, {34, 20, 14, 8}, {27, 16, 11, 7}, {17, 10, 7, 4}, 
				{77, 47, 32, 20}, {63, 38, 26, 16}, {48, 29, 20, 12}, {34, 20, 14, 8}, 
				{127, 77, 53, 32}, {101, 61, 42, 26}, {77, 47, 32, 20}, {58, 35, 24, 15}, 
				{187, 114, 78, 48}, {149, 90, 62, 38}, {111, 67, 46, 28}, {82, 50, 34, 21}, 
				{255, 154, 106, 65}, {202, 122, 84, 52}, {144, 87, 60, 37}, {106, 64, 44, 27}, 
				{322, 195, 134, 82}, {255, 154, 106, 65}, {178, 108, 74, 45}, {139, 84, 58, 36}, 
				{370, 224, 154, 95}, {293, 178, 122, 75}, {207, 125, 86, 53}, {154, 93, 64, 39}, 
				{461, 279, 192, 118}, {365, 221, 152, 93}, {259, 157, 108, 66}, {202, 122, 84, 52}, 
				{552, 335, 230, 141}, {432, 262, 180, 111}, {312, 189, 130, 80}, {235, 143, 98, 60}, 
				{652, 395, 271, 167}, {513, 311, 213, 131}, {364, 221, 151, 93}, {288, 174, 119, 74}, 
				{772, 468, 321, 198}, {604, 366, 251, 155}, {427, 259, 177, 109}, {331, 200, 137, 85}, 
				{883, 535, 367, 226}, {691, 419, 287, 177}, {489, 296, 203, 125}, {374, 227, 155, 96}, 
				{1022, 619, 425, 262}, {796, 483, 331, 204}, {580, 352, 241, 149}, {427, 259, 177, 109}, 
				{1101, 667, 458, 282}, {871, 528, 362, 223}, {621, 376, 258, 159}, {468, 283, 194, 120}, 
				{1250, 758, 520, 320}, {991, 600, 412, 254}, {703, 426, 292, 180}, {530, 321, 220, 136}, 
				{1408, 854, 586, 361}, {1082, 656, 450, 277}, {775, 470, 322, 198}, {602, 365, 250, 154}, 
				{1548, 938, 644, 397}, {1212, 734, 504, 310}, {876, 531, 364, 224}, {674, 408, 280, 173}, 
				{1725, 1046, 718, 442}, {1346, 816, 560, 345}, {948, 574, 394, 243}, {746, 452, 310, 191}, 
				{1903, 1153, 792, 488}, {1500, 909, 624, 384}, {1063, 644, 442, 272}, {813, 493, 338, 208}, 
				{2061, 1249, 858, 528}, {1600, 970, 666, 410}, {1159, 702, 482, 297}, {919, 557, 382, 235}, 
				{2232, 1352, 929, 572}, {1708, 1035, 711, 438}, {1224, 742, 509, 314}, {969, 587, 403, 248}, 
				{2409, 1460, 1003, 618}, {1872, 1134, 779, 480}, {1358, 823, 565, 348}, {1056, 640, 439, 270}, 
				{2620, 1588, 1091, 672}, {2059, 1248, 857, 528}, {1468, 890, 611, 376}, {1108, 672, 461, 284}, 
				{2812, 1704, 1171, 721}, {2188, 1326, 911, 561}, {1588, 963, 661, 407}, {1228, 744, 511, 315}, 
				{3057, 1853, 1273, 784}, {2395, 1451, 997, 614}, {1718, 1041, 715, 440}, {1286, 779, 535, 330}, 
				{3283, 1990, 1367, 842}, {2544, 1542, 1059, 652}, {1804, 1094, 751, 462}, {1425, 864, 593, 365}, 
				{3517, 2132, 1465, 902}, {2701, 1637, 1125, 692}, {1933, 1172, 805, 496}, {1501, 910, 625, 385}, 
				{3669, 2223, 1528, 940}, {2857, 1732, 1190, 732}, {2085, 1263, 868, 534}, {1581, 958, 658, 405}, 
				{3909, 2369, 1628, 1002}, {3035, 1839, 1264, 778}, {2181, 1322, 908, 559}, {1677, 1016, 698, 430}, 
				{4158, 2520, 1732, 1066}, {3289, 1994, 1370, 843}, {2358, 1429, 982, 604}, {1782, 1080, 742, 457}, 
				{4417, 2677, 1840, 1132}, {3486, 2113, 1452, 894}, {2473, 1499, 1030, 634}, {1897, 1150, 790, 486}, 
				{4686, 2840, 1952, 1201}, {3693, 2238, 1538, 947}, {2670, 1618, 1112, 684}, {2022, 1226, 842, 518}, 
				{4965, 3009, 2068, 1273}, {3909, 2369, 1628, 1002}, {2805, 1700, 1168, 719}, {2157, 1307, 898, 553}, 
				{5253, 3183, 2188, 1347}, {4134, 2506, 1722, 1060}, {2949, 1787, 1228, 756}, {2301, 1394, 958, 590}, 
				{5529, 3351, 2303, 1417}, {4343, 2632, 1809, 1113}, {3081, 1867, 1283, 790}, {2361, 1431, 983, 605}, 
				{5836, 3537, 2431, 1496}, {4588, 2780, 1911, 1176}, {3244, 1966, 1351, 832}, {2524, 1530, 1051, 647}, 
				{6153, 3729, 2563, 1577}, {4775, 2894, 1989, 1224}, {3417, 2071, 1423, 876}, {2625, 1591, 1093, 673}, 
				{6479, 3927, 2699, 1661}, {5039, 3054, 2099, 1292}, {3599, 2181, 1499, 923}, {2735, 1658, 1139, 701}, 
				{6743, 4087, 2809, 1729}, {5313, 3220, 2213, 1362}, {3791, 2298, 1579, 972}, {2927, 1774, 1219, 750}, 
				{7089, 4296, 2953, 1817}, {5596, 3391, 2331, 1435}, {3993, 2420, 1663, 1024}, {3057, 1852, 1273, 784}};
		return temp[ver*4+lvl][enc];
	}

	public static int getMessageLength(int version, int type) {
		int[] temp = {19, 16, 13, 9, 34, 28, 22, 16, 55, 44, 34, 26, 80, 64, 48, 36, 108, 86, 62, 46, 136, 108, 76, 60, 156, 124, 88, 66, 194, 154, 110, 86, 232, 182, 132, 100, 274, 216, 154, 122, 324, 254, 180, 140, 370, 290, 206, 158, 428, 334, 244, 180, 461, 365, 261, 197, 523, 415, 295, 223, 589, 453, 325, 253, 647, 507, 367, 283, 721, 563, 397, 313, 795, 627, 445, 341, 861, 669, 485, 385, 932, 714, 512, 406, 1006, 782, 568, 442, 1094, 860, 614, 464, 1174, 914, 664, 514, 1276, 1000, 718, 538, 1370, 1062, 754, 596, 1468, 1128, 808, 628, 1531, 1193, 871, 661, 1631, 1267, 911, 701, 1735, 1373, 985, 745, 1843, 1455, 1033, 793, 1955, 1541, 1115, 845, 2071, 1631, 1171, 901, 2191, 1725, 1231, 961, 2306, 1812, 1286, 986, 2434, 1914, 1354, 1054, 2566, 1992, 1426, 1096, 2702, 2102, 1502, 1142, 2812, 2216, 1582, 1222, 2956, 2334, 1666, 1276};
		return temp[version*4+type];
	}

}