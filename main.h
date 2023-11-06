#ifndef BELLMANFORD_GPU_MAIN_H
#define BELLMANFORD_GPU_MAIN_H
#include <iostream>
#include <algorithm>
#include <cassert>
#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
#include <limits>
#include <stdio.h>
#include <string>
#include <string.h>
#include <ctime>
#include <chrono>
#include "utilities/utilities.h"

using namespace std;
using namespace std::chrono;
using std::cout;
using std::endl;

void bellmanFordSequential(std::string file, int debug);
int bellmanFordOnGPU(const char *file, int blocks, int blockSize, int debug);

#endif //BELLMANFORD_GPU_MAIN_H
