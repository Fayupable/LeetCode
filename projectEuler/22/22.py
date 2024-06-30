#Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names, begin by sorting it into alphabetical order. Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
#For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score of 938 * 53 = 49714.

file_txt="your txt path"
def name_score(name):
    return sum([ord(c) - ord('A') + 1 for c in name])

def main():
    with open(file_txt) as f:
        names = f.read().replace('"', '').split(',')
    names.sort()
    print(sum([(i + 1) * name_score(name) for i, name in enumerate(names)]))

if __name__ == '__main__':
    main()
