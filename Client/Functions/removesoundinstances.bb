Function removesoundinstances%()
    Local local0%
    snd_i\Field1[$00] = $00
    snd_i\Field0[$00] = $00
    snd_i\Field1[$01] = $00
    snd_i\Field0[$01] = $00
    snd_i\Field1[$02] = $00
    snd_i\Field0[$02] = $00
    For local0 = $00 To $0D Step $01
        If (local0 < $02) Then
            radiosfx($00, local0) = $00
            snd_i\Field57[local0] = $00
            snd_i\Field40[local0] = $00
            snd_i\Field41[local0] = $00
            snd_i\Field31[local0] = $00
            snd_i\Field13[local0] = $00
            snd_i\Field7[local0] = $00
            snd_i\Field5[local0] = $00
            snd_i\Field6[local0] = $00
            snd_i\Field26[local0] = $00
        EndIf
        If (local0 < $03) Then
            opendoorsfx($00, local0) = $00
            closedoorsfx($00, local0) = $00
            opendoorsfx($01, local0) = $00
            closedoorsfx($01, local0) = $00
            opendoorsfx($02, local0) = $00
            closedoorsfx($02, local0) = $00
            opendoorsfx($03, local0) = $00
            closedoorsfx($03, local0) = $00
            opendoorsfx($04, local0) = $00
            opendoorsfx($05, local0) = $00
            snd_i\Field2[local0] = $00
            snd_i\Field46[local0] = $00
            snd_i\Field53[local0] = $00
            coughsfx($00, local0) = $00
            coughsfx($01, local0) = $00
            snd_i\Field33[local0] = $00
        EndIf
        If (local0 < $04) Then
            snd_i\Field24[local0] = $00
            snd_i\Field44[local0] = $00
            snd_i\Field50[local0] = $00
            snd_i\Field30[local0] = $00
        EndIf
        If (local0 < $05) Then
            breathsfx($00, local0) = $00
            breathsfx($01, local0) = $00
        EndIf
        If (local0 < $06) Then
            ambientsfxamount[local0] = $00
            snd_i\Field27[local0] = $00
        EndIf
        If (local0 < $07) Then
            snd_i\Field49[local0] = $00
        EndIf
        If (local0 < $08) Then
            stepsfx($00, $00, local0) = $00
            stepsfx($00, $01, local0) = $00
            stepsfx($01, $00, local0) = $00
            stepsfx($01, $01, local0) = $00
            If (local0 < $03) Then
                stepsfx($02, $00, local0) = $00
                stepsfx($03, $00, local0) = $00
                stepsfx($04, $00, local0) = $00
            EndIf
            If (local0 < $02) Then
                stepsfx($05, $00, local0) = $00
            EndIf
            npcsound[local0] = $00
        EndIf
        If (local0 < $09) Then
            radiosfx($01, local0) = $00
            snd_i\Field45[local0] = $00
        EndIf
        If (local0 < $0C) Then
            roomambience[local0] = $00
        EndIf
        If (local0 < $0D) Then
            snd_i\Field56[local0] = $00
        EndIf
        If (local0 < $0E) Then
            snd_i\Field47[local0] = $00
        EndIf
        snd_i\Field51[local0] = $00
    Next
    snd_i\Field3 = $00
    snd_i\Field4 = $00
    snd_i\Field8 = $00
    snd_i\Field9 = $00
    snd_i\Field10 = $00
    snd_i\Field11 = $00
    snd_i\Field12 = $00
    snd_i\Field14 = $00
    snd_i\Field15 = $00
    snd_i\Field16 = $00
    snd_i\Field17 = $00
    snd_i\Field18 = $00
    snd_i\Field19 = $00
    snd_i\Field20 = $00
    snd_i\Field21 = $00
    snd_i\Field25 = $00
    snd_i\Field29 = $00
    snd_i\Field28 = $00
    snd_i\Field59 = $00
    snd_i\Field32 = $00
    snd_i\Field34 = $00
    snd_i\Field35 = $00
    snd_i\Field36 = $00
    snd_i\Field37 = $00
    snd_i\Field38 = $00
    snd_i\Field42 = $00
    snd_i\Field43 = $00
    snd_i\Field52 = $00
    snd_i\Field60 = $00
    snd_i\Field48 = $00
    snd_i\Field55 = $00
    snd_i\Field23 = $00
    snd_i\Field39 = $00
    snd_i\Field22 = $00
    snd_i\Field58 = $00
    snd_i\Field54 = $00
    snd_i\Field61 = $00
    snd_i\Field62 = $00
    snd_i\Field63 = $00
    Delete snd_i
    snd_i = Null
    Return $00
End Function
