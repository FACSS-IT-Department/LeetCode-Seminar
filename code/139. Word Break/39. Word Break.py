# LC Question 139 Word Break

# Ningjie Zhang / brooklynzhang@yahoo.com

def wordBreak(s, wordDict):
    """
    :type s: str
    :type wordDict: List[str]
    :rtype: bool
    """

    def iterationbreak(s, d, wordDict):
        if s in wordDict:
            d[s] = True
            return True
        if s in d:
            return d[s]

        for i in range(1, len(s)):
            left = s[:i]
            right = s[i:]
            if right in wordDict and iterationbreak(left, d, wordDict):
                d[right] = True
                return True

        d[s] = False
        return False

    return iterationbreak(s, {}, wordDict)

if __name__ == "__main__":
    s = "aaaaa"
    words = ["aa","aaa"]
    s = wordBreak(s, words)
    print (s)