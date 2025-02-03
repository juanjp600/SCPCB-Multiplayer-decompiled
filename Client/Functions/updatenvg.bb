Function updatenvg%()
    Local local0.npcs
    Local local1%
    wi\Field7 = $00
    wi\Field8 = $00
    If ((((wi\Field5 > $00) Lor (wi\Field9 > $00)) And (wi\Field5 <> $03)) <> 0) Then
        For local1 = $00 To (maxitemamount - $01) Step $01
            If (inventory(local1) <> Null) Then
                If ((((((wi\Field5 = $01) And (inventory(local1)\Field4\Field2 = $40)) Lor ((wi\Field5 = $02) And (inventory(local1)\Field4\Field2 = $41))) Lor ((wi\Field9 = $01) And (inventory(local1)\Field4\Field2 = $43))) Lor ((wi\Field9 = $02) And (inventory(local1)\Field4\Field2 = $44))) <> 0) Then
                    If (wi\Field5 > $00) Then
                        inventory(local1)\Field12 = max(0.0, (inventory(local1)\Field12 - (fps\Field7[$00] * (0.04 / (Float wi\Field5)))))
                    EndIf
                    If (wi\Field9 > $00) Then
                        inventory(local1)\Field12 = max(0.0, (inventory(local1)\Field12 - (fps\Field7[$00] * (0.08 / (Float wi\Field9)))))
                    EndIf
                    wi\Field8 = (Int inventory(local1)\Field12)
                    Exit
                EndIf
            EndIf
        Next
        If (wi\Field8 = $00) Then
            createhintmsg(getlocalstring("msg", "bat.combine"), 1.0, $01)
            If (wi\Field9 > $00) Then
                createmsg(getlocalstring("msg", "battery.died"), 6.0)
            Else
                createmsg(getlocalstring("msg", "battery.died.nvg"), 6.0)
            EndIf
            wi\Field7 = $01
        EndIf
    EndIf
    If (wi\Field8 > $00) Then
        If (wi\Field9 = $02) Then
            n_i\Field2\Field44 = entityx(n_i\Field2\Field3, $01)
            n_i\Field2\Field45 = entityy(n_i\Field2\Field3, $01)
            n_i\Field2\Field46 = entityz(n_i\Field2\Field3, $01)
        ElseIf (wi\Field5 = $02) Then
            If (0.0 >= wi\Field6) Then
                For local0 = Each npcs
                    local0\Field44 = entityx(local0\Field3, $01)
                    local0\Field45 = entityy(local0\Field3, $01)
                    local0\Field46 = entityz(local0\Field3, $01)
                Next
                wi\Field7 = $01
                If (-10.0 >= wi\Field6) Then
                    wi\Field6 = 600.0
                EndIf
            EndIf
            wi\Field6 = (wi\Field6 - fps\Field7[$00])
        EndIf
        If (wi\Field8 < $A0) Then
            If (70.0 <= batmsgtimer) Then
                If (channelplaying(lowbatterychn[$01]) = $00) Then
                    me\Field42 = max(3.0, me\Field42)
                    lowbatterychn[$01] = playsound_strict(snd_i\Field41[$01], $00, $01)
                EndIf
            EndIf
        EndIf
    EndIf
    Return $00
End Function
