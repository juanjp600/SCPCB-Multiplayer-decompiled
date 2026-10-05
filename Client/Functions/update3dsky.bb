Function update3dsky%(arg0%)
    Local local0#
    Local local1#
    Local local2#
    Local local3#
    Local local4#
    Local local5#
    If (sky[arg0] = $00) Then
        Return $00
    EndIf
    showentity(sky[arg0])
    local0 = entityx(collider, $01)
    local1 = entityy(collider, $01)
    local2 = entityz(collider, $01)
    local3 = ((local0 * (1.0 / 5.12)) + 900.0)
    local4 = ((local1 * (1.0 / 5.12)) + 1.0)
    local5 = ((local2 * (1.0 / 5.12)) + 900.0)
    positionentity(landscapecamera, local3, local4, local5, $01)
    rotateentity(landscapecamera, entitypitch(camera, $00), entityyaw(camera, $00), entityroll(camera, $00), $00)
    Return $00
End Function
