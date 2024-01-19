Function playerdropitem%(arg0.items)
    positionentity(arg0\Field1, player[arg0\Field22]\Field0, (player[arg0\Field22]\Field1 + 0.6), player[arg0\Field22]\Field2, $01)
    resetentity(arg0\Field1)
    rotateentity(arg0\Field1, 0.0, (entityyaw(player[arg0\Field22]\Field62, $00) + rnd(-110.0, 110.0)), 0.0, $00)
    moveentity(arg0\Field1, 0.0, -0.1, 0.0)
    arg0\Field29 = -14934890.0
    arg0\Field22 = $00
    arg0\Field15 = $00
    arg0\Field31 = $00
    Return $00
End Function
