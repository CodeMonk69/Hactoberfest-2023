// SPDX-License-Identifier: MIT
pragma solidity >=0.7 <0.9;

contract PalindromeChecker {
    function isPalindrome(string memory str) public pure returns (bool) {
        bytes memory strBytes = bytes(str);
        uint256 length = strBytes.length;

        for (uint256 i = 0; i < length / 2; i++) {
            if (strBytes[i] != strBytes[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
