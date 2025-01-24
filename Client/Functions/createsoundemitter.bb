Function createsoundemitter.soundemitters(arg0.rooms, arg1%, arg2#, arg3#, arg4#, arg5#)
    Local local0.soundemitters
    local0 = (New soundemitters)
    local0\Field4 = arg0
    local0\Field0 = createpivot($00)
    positionentity(local0\Field0, arg2, arg3, arg4, $00)
    If (arg0 <> Null) Then
        entityparent(local0\Field0, arg0\Field2, $01)
    EndIf
    local0\Field1 = arg1
    local0\Field2 = arg5
    Return local0
    Return Null
End Function
