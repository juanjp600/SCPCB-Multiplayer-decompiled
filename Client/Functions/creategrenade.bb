Function creategrenade%(arg0%, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%, arg7%)
    Local local0.grenades
    local0 = (New grenades)
    Select arg0
        Case $0D
            local0\Field2 = copyentity(grenade_object, $00)
        Case $0E
            local0\Field2 = copyentity(grenadeflashbang_object, $00)
        Case $0F
            local0\Field2 = copyentity(grenadesmoke_object, $00)
    End Select
    scaleentity(local0\Field2, 0.012, 0.012, 0.012, $00)
    positionentity(local0\Field2, arg1, arg2, arg3, $00)
    rotateentity(local0\Field2, arg4, arg5, -20.0, $00)
    entitytype(local0\Field2, $08, $00)
    entityradius(local0\Field2, 0.03, 0.0)
    local0\Field3 = (0.12 - ((Float arg7) * 0.09))
    local0\Field14 = 0.008
    local0\Field5 = arg5
    local0\Field18 = arg6
    local0\Field19 = arg0
    local0\Field20 = 0.0
    local0\Field4 = -20.0
    If (arg7 = $01) Then
        rotateentity(local0\Field2, -30.0, arg5, -20.0, $00)
    EndIf
    Return $00
End Function
