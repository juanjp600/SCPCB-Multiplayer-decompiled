Function updatedust%()
    Local local0%
    dustparticlechance = (Int max((Float ((((opt\Field0 = $01) * $19) + $23) - ((0.0 < me\Field24) * $23))), 1.0))
    If (rand(dustparticlechance, $01) = $01) Then
        setemitter(Null, entityx(camera, $01), entityy(camera, $01), entityz(camera, $01), $0C)
    EndIf
    Return $00
End Function
