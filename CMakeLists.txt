cmake_minimum_required(VERSION 3.20)
project(LeetCode LANGUAGES C CXX)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")  #设置c++的编译选项
set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -std=c99")  #设置c的编译选项
#aux_source_directory(. DIR_SRCS)
set(CMAKE_EXPORT_COMPILE_COMMANDS ON)

# 动态库文件目录
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY target/lib)

# 可执行文件目录
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY target/bin)

INCLUDE_DIRECTORIES(${PROJECT_SOURCE_DIR}/lib/includes)

#file(GLOB C_Source_FILES src/main/c*/*.c)
#file(GLOB CPP_Source_FILES src/main/cpp/*.cpp)

function(BuildFile Source_Path)
    file(GLOB Source_FILES ${Source_Path})

    foreach(Source_FILE ${Source_FILES})
        if(${Source_FILE} MATCHES "[.]c")
            # 如果是文件，编译
            STRING(REGEX REPLACE ".+/(.+)\\..*" "\\1" FILE_NAME ${Source_FILE})
            message(${FILE_NAME})
            add_executable(${FILE_NAME} ${Source_FILE})
        ELSE()
            # 如果是文件夹，递归
            BuildFile(${Source_FILE}/*)
        endif()
    endforeach()
endfunction(BuildFile)

BuildFile(src/main/c/*)
BuildFile(src/main/cpp/*)

#add_executable(T0061 src/main/c/t0001_t0500/t0001_t0100/t0061_t0070/T0061.c)
#add_executable(T0162 src/main/c/t0001_t0500/t0101_t0200/t0161_t0170/T0162.c)
#add_executable(T0219 src/main/c/t0001_t0500/t0201_t0300/t0211_t0220/T0219.c)
#add_executable(T0268 src/main/c/t0001_t0500/t0201_t0300/t0261_t0270/T0268.c)
#add_executable(T0367 src/main/c/t0001_t0500/t0301_t0400/t0361_t0370/T0367.c)
#add_executable(T0453 src/main/c/t0001_t0500/t0401_t0500/t0451_t0460/T0453.c)
#add_executable(T0476 src/main/c/t0001_t0500/t0401_t0500/t0471_t0480/T0476.c)
#add_executable(T0495 src/main/c/t0001_t0500/t0401_t0500/t0491_t0500/T0495.c)
#add_executable(T0561 src/main/c/t0501_t1000/t0501_t0600/t0561_t0570/T0561.c)
#add_executable(T0598 src/main/c/t0501_t1000/t0501_t0600/t0591_t0600/T0598.c)
#add_executable(T0628 src/main/c/t0501_t1000/t0601_t0700/t0621_t0630/T0628.c)
#add_executable(T0747 src/main/c/t0501_t1000/t0701_t0800/t0741_t0750/T0747.c)
#add_executable(T0831 src/main/c/t0501_t1000/t0801_t0900/t0831_t0840/T0831.c)
#add_executable(T0982 src/main/c/t0501_t1000/t0901_t1000/t0981_t0990/T0982.c)
#add_executable(T1005 src/main/c/t1001_t1500/t1000_t1100/t1001_t1010/T1005.c)
#add_executable(T1218 src/main/c/t1001_t1500/t1201_t1300/t1211_t1220/T1218.c)
#add_executable(T1487 src/main/c/t1001_t1500/t1401_t1500/t1481_t1490/T1487.c)
#add_executable(T1576 src/main/c/t1501_t2000/t1501_t1600/t1571_t1580/T1576.c)
#add_executable(T1599 src/main/c/t1501_t2000/t1501_t1600/t1591_t1600/T1599.c)
#add_executable(T1614 src/main/c/t1501_t2000/t1601_t1700/t1611_t1620/T1614.c)
#add_executable(T1653 src/main/c/t1501_t2000/t1601_t1700/t1651_t1660/T1653.c)
#add_executable(T1816 src/main/c/t1501_t2000/t1801_t1900/t1811_t1820/T1816.c)
#add_executable(T1957 src/main/c/t1501_t2000/t1901_t2000/t1951_t1960/T1957.c)
#add_executable(T2373 src/main/c/t2001_t2500/t2301_t2400/t2371_t2380/T2373.c)
#add_executable(T2379 src/main/c/t2001_t2500/t2301_t2400/t2371_t2380/T2379.c)
#
#add_executable(T05_02 src/main/c/interview/T05_02.c)
#
#add_executable(T047 src/main/c/to_offer/t041_t050/T047.c)
#
#add_executable(T0628cpp src/main/cpp/t0501_t1000/t0601_t0700/t0621_t0630/T0628.cpp)
#add_executable(T0831cpp src/main/cpp/t0501_t1000/t0801_t0900/t0831_t0840/T0831.cpp)
#add_executable(T0982cpp src/main/cpp/t0501_t1000/t0901_t1000/t0981_t0990/T0982.cpp)
#add_executable(T1487cpp src/main/cpp/t1001_t1500/t1401_t1500/t1481_t1490/T1487.cpp)
#add_executable(T1599cpp src/main/cpp/t1501_t2000/t1501_t1600/t1591_t1600/T1599.cpp)
#add_executable(T1653cpp src/main/cpp/t1501_t2000/t1601_t1700/t1651_t1660/T1653.cpp)
#add_executable(T1957cpp src/main/cpp/t1501_t2000/t1901_t2000/t1951_t1960/T1957.cpp)
#add_executable(T2373cpp src/main/cpp/t2001_t2500/t2301_t2400/t2371_t2380/T2373.cpp)
#add_executable(T2379cpp src/main/cpp/t2001_t2500/t2301_t2400/t2371_t2380/T2379.cpp)
#
#add_executable(T05_02cpp src/main/cpp/interview/T05_02.cpp)
#
#add_executable(T047cpp src/main/cpp/to_offer/t041_t050/T047.cpp)