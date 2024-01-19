Function updatetimers%()
    Local local0.timers
    Local local1%
    For local0 = Each timers
        If (local0\Field4 < millisecs()) Then
            If (local0\Field7 <> $00) Then
                For local1 = $01 To len(local0\Field2) Step $01
                    Select mid(local0\Field2, local1, $01)
                        Case "i"
                            public_addparam($00, (Str bytestreamreadint(local0\Field1)), $03)
                        Case "f"
                            public_addparam($00, (Str bytestreamreadfloat(local0\Field1)), $03)
                        Case "s"
                            public_addparam($00, bytestreamreadstring(local0\Field1), $04)
                    End Select
                Next
                public_update_by_func(Null, $00, local0\Field7, local0\Field8)
            Else
                For local1 = $01 To len(local0\Field2) Step $01
                    Select mid(local0\Field2, local1, $01)
                        Case "i"
                            public_addparam($00, (Str bytestreamreadint(local0\Field1)), $01)
                        Case "f"
                            public_addparam($00, (Str bytestreamreadfloat(local0\Field1)), $02)
                        Case "s"
                            public_addparam($00, bytestreamreadstring(local0\Field1), $03)
                    End Select
                Next
                public_update_by_func(local0\Field6, $00, $00, "")
            EndIf
            public_clear()
            If (local0 <> Null) Then
                If (local0\Field5 <> 0) Then
                    local0\Field4 = (millisecs() + local0\Field3)
                    bytestreamresetread(local0\Field1)
                Else
                    removetimer(local0)
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
