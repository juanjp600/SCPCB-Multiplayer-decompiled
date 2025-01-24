Function mp_updatenpcobject%(arg0.npcs)
    If (((arg0\Field87 = $00) And (mp_ishoster() = $00)) <> 0) Then
        arg0\Field82 = curveangle(arg0\Field76, arg0\Field82, 4.0)
        arg0\Field81 = curveangle(arg0\Field75, arg0\Field81, 4.0)
        rotateentity(arg0\Field3, entitypitch(arg0\Field3, $01), arg0\Field81, entityroll(arg0\Field3, $01), $01)
        rotateentity(arg0\Field0, entitypitch(arg0\Field0, $01), arg0\Field82, entityroll(arg0\Field0, $01), $01)
    EndIf
    Return $00
End Function
