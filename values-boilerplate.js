fs = require('fs')
log = console.log
file = 'src/org/usfirst/frc6442/Robot2018StartAgain/RobotValues.java'
content = fs.readFileSync(file, 'utf8')
lines = content.split('\n')
//log(lines)
re = /^\s*public\s+(\w+)\s+(\w+)(?:\s*=\s*([^;]+))?\s*;/
vars = lines.map(line => line.match(re)).filter(x => x)
//log(vars.map(x=>x[2]))
ucFirst = s => s[0].toUpperCase() + s.slice(1)
outs = vars.map(([l, type, name, value]) => {
  let method = 'get' + ucFirst(type)
  return `${name} = ${method}("${name}", ${value || 0});`
})
log(outs.join("\n"))