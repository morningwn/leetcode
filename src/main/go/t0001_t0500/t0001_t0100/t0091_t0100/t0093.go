package t0091_t0100

import "bytes"

// 93. 复原 IP 地址
// https://leetcode.cn/problems/restore-ip-addresses/

func restoreIpAddresses(s string) []string {
	addresses := make([]string, 0)

	for i := 1; i <= 3 && i < len(s); i++ {
		for j := i + 1; j <= i+3 && j < len(s); j++ {
			for k := j + 1; k <= j+3 && k < len(s); k++ {
				for l := k + 1; l <= k+3 && l <= len(s); l++ {
					var buffer bytes.Buffer
					if checkIpNum(s[0:i]) {
						buffer.WriteString(s[0:i])
					} else {
						continue
					}
					if checkIpNum(s[i:j]) {
						buffer.WriteString(".")
						buffer.WriteString(s[i:j])
					} else {
						continue
					}
					if checkIpNum(s[j:k]) {
						buffer.WriteString(".")
						buffer.WriteString(s[j:k])
					} else {
						continue
					}
					if checkIpNum(s[k:l]) && l == len(s) {
						buffer.WriteString(".")
						buffer.WriteString(s[k:l])
						addresses = append(addresses, buffer.String())
					}
				}
			}
		}
	}

	return addresses
}

func checkIpNum(num string) bool {
	if len(num) > 1 && num[0] == '0' {
		return false
	}
	if len(num) >= 3 && (num[0] > '2' ||
		(num[0] == '2' && num[1] > '5') ||
		(num[0] == '2' && num[1] == '5' && num[2] > '5')) {
		return false
	}
	return true
}
