def obtenir_evenements():
    fd = open('evenements.txt', 'r', encoding='utf-8-sig')
    lines = fd.readlines()
    evenements = []

    for line in lines:
        split_lines = line.split('/')
        clean_lines = []
        for raw_line in split_lines:
            clean_line = raw_line.strip("\n")
            clean_lines.append(clean_line)
        evenements.append(clean_lines)
    fd.close()
    return evenements

print(obtenir_evenements())