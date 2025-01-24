Function mp_updateroomobjects%()
    Local local0.mp_roomobject
    Local local1%
    Local local2.mp_roomlever
    If (mp_ishoster() <> 0) Then
        Return $00
    EndIf
    If (((myplayerlogic\Field4 <> Null) And (0.0 >= myplayerlogic\Field4\Field16)) <> 0) Then
        myplayerlogic\Field4 = Null
    EndIf
    If (((myplayerlogic\Field5 <> Null) And (0.0 >= myplayerlogic\Field5\Field10)) <> 0) Then
        myplayerlogic\Field5 = Null
    EndIf
    For local0 = Each mp_roomobject
        local1 = local0\Field0\Field11[local0\Field1]
        If (local1 <> $00) Then
            If (local1 <> grabbedentity) Then
                local0\Field16 = (local0\Field16 - fps\Field7[$01])
                If (0.0 >= local0\Field16) Then
                    positionentity(local1, curvevalue(local0\Field8, entityx(local1, $01), 4.0), curvevalue(local0\Field9, entityy(local1, $01), 4.0), curvevalue(local0\Field10, entityz(local1, $01), 4.0), $01)
                    rotateentity(local1, clamp(curvevalue(local0\Field11, entitypitch(local1, $01), 4.0), -89.9, 89.9), curveangle(local0\Field12, entityyaw(local1, $01), 4.0), curveangle(local0\Field13, entityroll(local1, $01), 4.0), $01)
                EndIf
            Else
                myplayerlogic\Field4 = local0
                local0\Field16 = 35.0
            EndIf
        EndIf
    Next
    For local2 = Each mp_roomlever
        local1 = local2\Field0\Field13[local2\Field1]\Field0
        If (local1 <> $00) Then
            If (local1 <> grabbedentity) Then
                local2\Field10 = (local2\Field10 - fps\Field7[$01])
                If (0.0 >= local2\Field10) Then
                    rotateentity(local1, clamp(curvevalue(local2\Field5, entitypitch(local1, $01), 4.0), -89.9, 89.9), curveangle(local2\Field6, entityyaw(local1, $01), 4.0), curveangle(local2\Field7, entityroll(local1, $01), 4.0), $01)
                EndIf
            Else
                myplayerlogic\Field5 = local2
                local2\Field10 = 35.0
            EndIf
        EndIf
    Next
    Return $00
End Function
