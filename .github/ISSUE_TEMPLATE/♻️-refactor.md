---
name: "♻️ Refactor"
about: 리팩토링 이슈 템플릿
title: "♻️Refactor: "
labels: ":recycle: Refactor"
assignees: ''

---

##  :memo: Todo
- [ ]
- [ ]

Get-content labels.json | jq -c '.[]' | while read -r label; do
name=$(echo $label | jq -r '.name')
color=$(echo $label | jq -r '.color')
description=$(echo $label | jq -r '.description')

gh label create "$name" --color "$color" --description "$description" || \
gh label edit "$name" --color "$color" --description "$description"
done