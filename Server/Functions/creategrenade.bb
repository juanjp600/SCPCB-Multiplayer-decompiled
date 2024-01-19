Function creategrenade%(arg0#, arg1#, arg2#, arg3#, arg4#, arg5%, arg6%)
    Local local0.grenades
    local0 = (New grenades)
    local0\Field2 = copyentity(grenade_object, $00)
    scaleentity(local0\Field2, 0.012, 0.012, 0.012, $00)
    positionentity(local0\Field2, arg0, arg1, arg2, $00)
    rotateentity(local0\Field2, arg3, arg4, -20.0, $00)
    entitytype(local0\Field2, $08, $00)
    entityradius(local0\Field2, 0.03, 0.0)
    local0\Field3 = (0.12 - ((Float arg6) * 0.09))
    local0\Field5 = arg4
    local0\Field14 = arg5
    If (player[arg5] <> Null) Then
        local0\Field16 = player[arg5]\Field36
    EndIf
    If (arg6 = $01) Then
        rotateentity(local0\Field2, -30.0, arg4, -20.0, $00)
    EndIf
    Return $00
End Function
