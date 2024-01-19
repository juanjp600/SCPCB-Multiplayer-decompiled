Function voice_wave_update%()
    Local local0.records
    Local local1.records
    For local0 = Each records
        If (local0\Field3 <> $00) Then
            alupdatesoundvolume(local0\Field0, camera, local0\Field3, 12.0, (local0\Field2 * (Float (1.0 > deaftimer))))
            alsourceset3dposition(local0\Field0, entityx(local0\Field3, $00), entityy(local0\Field3, $00), entityz(local0\Field3, $00))
        EndIf
        If (player[local0\Field7] <> Null) Then
            player[local0\Field7]\Field45 = $01
            player[local0\Field7]\Field66 = 10.0
        EndIf
        If (local0\Field4 = $00) Then
            If (alsourceisplaying(local0\Field0) = $00) Then
                alfreesource(local0\Field0)
                If (filetype(local0\Field5) <> $00) Then
                    deletefile(local0\Field5)
                EndIf
                Delete local0
            EndIf
        ElseIf (local0\Field6 < millisecs()) Then
            For local1 = Each records
                If (((local1\Field4 = $01) And (local1 <> local0)) <> 0) Then
                    alsourceremoveeffect(local1\Field0, $00)
                    alfreesource(local1\Field0)
                    If (filetype(local1\Field5) <> $00) Then
                        deletefile(local1\Field5)
                    EndIf
                    Delete local1
                EndIf
            Next
            alsourceremoveeffect(local0\Field0, $00)
            alfreesource(local0\Field0)
            If (filetype(local0\Field5) <> $00) Then
                deletefile(local0\Field5)
            EndIf
            Delete local0
            If (echo_effect <> $00) Then
                alfreeeffect(echo_effect)
                echo_effect = alcreateeffect()
                If (echo_effect <> $00) Then
                    aleffectseteaxreverbparam(echo_effect, 0.316, 0.25, 1.0, 0.017, 0.54, 0.653, 0.01, 0.01, 3.273, 0.1, 0.01, 0.1, 0.1, 1.0, 0.9, $01, 0.1, 0.1, 0.04, 1000.0, 20.0)
                    aleffectsetpreset(echo_effect, "Dizzy")
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
