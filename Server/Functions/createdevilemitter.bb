Function createdevilemitter.devilemitters(arg0#, arg1#, arg2#, arg3.rooms, arg4%, arg5#)
    Local local0.devilemitters
    local0 = (New devilemitters)
    local0\Field0 = createpivot($00)
    nameentity(local0\Field0, "Emitter2")
    positionentity(local0\Field0, arg0, arg1, arg2, $01)
    entityparent(local0\Field0, arg3\Field2, $01)
    local0\Field5 = arg3
    local0\Field1 = arg0
    local0\Field2 = arg1
    local0\Field3 = arg2
    local0\Field4 = arg4
    local0\Field7 = arg5
    Return local0
    Return Null
End Function
