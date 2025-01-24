Function rendermessages%()
    Local local0%
    Local local1%
    Local local2%
    Local local3%
    If (((selecteddifficulty\Field0 = difficulties[$03]\Field0) Lor (opt\Field32 = $00)) <> 0) Then
        Return $00
    EndIf
    If (0.0 < msg\Field1) Then
        If ((invopen Lor (otheropen <> Null)) = $00) Then
            local0 = (((i_294\Field0 Lor (d_i\Field6 <> Null)) Lor (selectedscreen <> Null)) Lor ((selecteditem <> Null) And (((((((selecteditem\Field4\Field2 = $00) Lor (selecteditem\Field4\Field2 = $20)) Lor (selecteditem\Field4\Field2 = $21)) Lor (selecteditem\Field4\Field2 = $01)) Lor (selecteditem\Field4\Field2 = $4D)) Lor (selecteditem\Field4\Field2 = $4E)) Lor (selecteditem\Field4\Field2 = $4F))))
        EndIf
        local1 = (Int min((msg\Field1 / 2.0), 255.0))
        setfontex(fo\Field0[$00])
        color(local1, local1, local1)
        local2 = (Int ((Float mo\Field10) + (200.0 * menuscale)))
        If (local0 <> 0) Then
            local2 = (Int ((Float opt\Field47) * 0.94))
        EndIf
        textex((Int (((Float ((-200.0 > me\Field5) * rand($FFFFFFF6, $0A))) * menuscale) + (Float mo\Field9))), (Int (((Float ((-200.0 > me\Field5) * rand($FFFFFFF6, $0A))) * menuscale) + (Float local2))), msg\Field0, $01, $00)
    EndIf
    color($FF, $FF, $FF)
    If (opt\Field33 <> 0) Then
        local3 = (Int (20.0 * menuscale))
        setfontex(fo\Field0[$05])
        textex(local3, local3, ("FPS: " + (Str fps\Field3)), $00, $00)
        setfontex(fo\Field0[$00])
    EndIf
    Return $00
End Function
