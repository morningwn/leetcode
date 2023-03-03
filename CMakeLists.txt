cmake_minimum_required(VERSION 3.20)
project(LeetCode LANGUAGES C CXX)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")  #设置c++的编译选项
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -std=c99")  #设置c的编译选项
#aux_source_directory(. DIR_SRCS)
#set(CMAKE_EXPORT_COMPILE_COMMANDS True)

INCLUDE_DIRECTORIES(includes)

add_executable(T0061 src/main/c/t0001_t0500/t0001_t0100/t0061_t0070/T0061.c)
add_executable(T0162 src/main/c/t0001_t0500/t0101_t0200/t0161_t0170/T0162.c)
add_executable(T0219 src/main/c/t0001_t0500/t0201_t0300/t0211_t0220/T0219.c)
add_executable(T0268 src/main/c/t0001_t0500/t0201_t0300/t0261_t0270/T0268.c)
add_executable(T0367 src/main/c/t0001_t0500/t0301_t0400/t0361_t0370/T0367.c)
add_executable(T0453 src/main/c/t0001_t0500/t0401_t0500/t0451_t0460/T0453.c)
add_executable(T0476 src/main/c/t0001_t0500/t0401_t0500/t0471_t0480/T0476.c)
add_executable(T0495 src/main/c/t0001_t0500/t0401_t0500/t0491_t0500/T0495.c)
add_executable(T0561 src/main/c/t0501_t1000/t0501_t0600/t0561_t0570/T0561.c)
add_executable(T0598 src/main/c/t0501_t1000/t0501_t0600/t0591_t0600/T0598.c)
add_executable(T0747 src/main/c/t0501_t1000/t0701_t0800/t0741_t0750/T0747.c)
add_executable(T1005 src/main/c/t1001_t1500/t1000_t1100/t1001_t1010/T1005.c)
add_executable(T1218 src/main/c/t1001_t1500/t1201_t1300/t1211_t1220/T1218.c)
add_executable(T1487 src/main/c/t1001_t1500/t1401_t1500/t1481_t1490/T1487.c)
add_executable(T1576 src/main/c/t1501_t2000/t1501_t1600/t1571_t1580/T1576.c)
add_executable(T1614 src/main/c/t1501_t2000/t1601_t1700/t1611_t1620/T1614.c)
add_executable(T1816 src/main/c/t1501_t2000/t1801_t1900/t1811_t1820/T1816.c)
add_executable(T2373 src/main/c/t2001_t2500/t2301_t2400/t2371_t2380/T2373.c)

add_executable(T05_02 src/main/c/interview/T05_02.c)

add_executable(T2373cpp src/main/cpp/t2001_t2500/t2301_t2400/t2371_t2380/T2373.cpp)
add_executable(T1487cpp src/main/cpp/t1001_t1500/t1401_t1500/t1481_t1490/T1487.cpp)

add_executable(T05_02cpp src/main/cpp/interview/T05_02.cpp)