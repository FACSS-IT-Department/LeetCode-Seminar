def mergesort(nums, left, right):
    if left < right:
        mid = (left + right) // 2
        mergesort(nums, left, mid)
        mergesort(nums, mid+1, right)
        merge(nums, left, mid, right)

def merge(nums, left, mid, right):
    n1 = mid - left + 1
    n2 = right - mid
    L = []
    R = []
    for i in range(n1):
        L.append(nums[left + i])
    for j in range(n2):
        R.append(nums[mid + j + 1])
    L.append(max(nums) + 1)
    R.append(max(nums) + 1)
    i, j = 0, 0
    for k in range(left, right+1):
        if L[i] <= R[j]:
            nums[k] = L[i]
            i += 1
        else:
            nums[k] = R[j]
            j += 1


if __name__ == "__main__":
    list2 = [2, 9, 1, 3, 4, 8, 7, 6, 6, 5]
    mergesort(list2, 0, len(list2) - 1)
    print(list2)