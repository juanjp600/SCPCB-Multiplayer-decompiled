Function applyplayertagattributes%(arg0.mp_player, arg1%)
    Local local0.mp_playertag
    Local local1.spritefont
    clearplayertag(arg0, arg1)
    local0 = arg0\Field34[arg1]
    local1 = findspritefont(local0\Field0)
    If (local1 = Null) Then
        Return $00
    EndIf
    local0\Field1 = createspritetext(local1, local0\Field2, local0\Field6, local0\Field7)
    entityparent(local0\Field1, arg0\Field18, $01)
    scalesprite(local0\Field1, (local0\Field3 * (128.0 / local1\Field3)), local0\Field4)
    positionentity(local0\Field1, 0.0, local0\Field5, 0.0, $00)
    Return $00
End Function
