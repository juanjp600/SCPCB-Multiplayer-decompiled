Function createscreen.screens(arg0.rooms, arg1#, arg2#, arg3#, arg4$)
    Local local0.screens
    local0 = (New screens)
    local0\Field0 = createpivot($00)
    entityradius(local0\Field0, 0.1, 0.0)
    entitypickmode(local0\Field0, $01, $01)
    positionentity(local0\Field0, arg1, arg2, arg3, $00)
    If (arg0 <> Null) Then
        entityparent(local0\Field0, arg0\Field2, $01)
    EndIf
    local0\Field1 = arg4
    local0\Field3 = arg0
    Return local0
    Return Null
End Function
