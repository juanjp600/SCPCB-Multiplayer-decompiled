Function createrocket.rockets(arg0#, arg1#, arg2#, arg3#, arg4#, arg5#, arg6%)
    Local local0.rockets
    local0 = (New rockets)
    local0\Field2 = copyentity(rocket_object, $00)
    scaleentity(local0\Field2, 0.01, 0.01, 0.01, $00)
    local0\Field7 = arg4
    local0\Field8 = arg5
    local0\Field1 = createpivot($00)
    positionentity(local0\Field1, arg1, (arg2 + 0.2), arg3, $00)
    rotateentity(local0\Field1, arg4, arg5, 0.0, $00)
    rotateentity(local0\Field2, arg4, arg5, 0.0, $00)
    resetentity(local0\Field1)
    moveentity(local0\Field1, 0.1, -0.17, 0.0)
    local0\Field11 = arg6
    local0\Field5 = play3dsound($00, camera, local0\Field1, 20.0, 1.0, "SFX\Guns\Bazooka\shoot.ogg")
    local0\Field9 = createemitter(entityx(local0\Field2, $01), entityy(local0\Field2, $01), entityz(local0\Field2, $01), $00, 0.0)
    turnentity(local0\Field9\Field0, 90.0, 0.0, 0.0, $01)
    local0\Field9\Field10 = 5.0
    local0\Field9\Field9 = 0.0
    local0\Field9\Field13 = 0.1
    local0\Field9\Field11 = 0.01
    local0\Field9\Field4 = 0.0
    local0\Field9\Field2 = $06
    local0\Field9\Field3 = $06
    initroomforemitter(local0\Field9)
    Return local0
    Return Null
End Function
