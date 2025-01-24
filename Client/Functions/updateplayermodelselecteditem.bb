Function updateplayermodelselecteditem%(arg0.mp_player)
    Local local0.items
    If (arg0\Field26 > $00) Then
        If ((((0.0 <> arg0\Field35\Field1\Field13) Lor (0.0 <> arg0\Field35\Field1\Field14)) Lor (0.0 <> arg0\Field35\Field1\Field15)) <> 0) Then
            rotateentity(arg0\Field35\Field5, arg0\Field35\Field1\Field13, arg0\Field35\Field1\Field14, arg0\Field35\Field1\Field15, $00)
        EndIf
        local0 = mp_items[arg0\Field26]
        If (((local0 <> Null) And local0\Field15) <> 0) Then
            positionentity(local0\Field2, entityx(arg0\Field35\Field4, $01), entityy(arg0\Field35\Field4, $01), entityz(arg0\Field35\Field4, $01), $01)
            rotateentity(local0\Field2, (entitypitch(arg0\Field35\Field4, $01) + arg0\Field35\Field1\Field19), (entityyaw(arg0\Field35\Field4, $01) + arg0\Field35\Field1\Field20), (entityroll(arg0\Field35\Field4, $01) + arg0\Field35\Field1\Field21), $01)
            moveentity(local0\Field2, arg0\Field35\Field1\Field16, arg0\Field35\Field1\Field17, arg0\Field35\Field1\Field18)
            resetentity(local0\Field2)
            showentity(local0\Field2)
        EndIf
    EndIf
    Return $00
End Function
