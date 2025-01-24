Function createlever.levers(arg0.rooms, arg1#, arg2#, arg3#, arg4#, arg5%)
    Local local0.levers
    local0 = (New levers)
    local0\Field2 = arg0
    local0\Field1 = copyentity(lvr_i\Field0[$00], $00)
    scaleentity(local0\Field1, 0.036, 0.036, 0.036, $00)
    positionentity(local0\Field1, arg1, arg2, arg3, $01)
    entityparent(local0\Field1, arg0\Field2, $01)
    rotateentity(local0\Field1, 0.0, arg4, 0.0, $00)
    local0\Field0 = copyentity(lvr_i\Field0[$01], $00)
    scaleentity(local0\Field0, 0.036, 0.036, 0.036, $00)
    positionentity(local0\Field0, arg1, arg2, arg3, $01)
    entityparent(local0\Field0, arg0\Field2, $01)
    rotateentity(local0\Field0, ((-160.0 * (Float arg5)) + 80.0), (arg4 - 180.0), 0.0, $00)
    entityradius(local0\Field0, 0.1, 0.0)
    entitypickmode(local0\Field0, $01, $00)
    Return local0
    Return Null
End Function
