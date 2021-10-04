class Solution:
    def trap(self, height) -> int:

        highest = 0
        second_highest = 0

        for i in range(len(height)):
            if height[i] > 0 and highest < height[i]:
                highest = height[i]
            elif height[i] > 0 and second_highest < height[i]:
                second_highest = height[i]

