Function updatetimers%()
    Local local0.timers
    Local local1%
    For local0 = Each timers
        If (local0\Field4 < millisecs()) Then
            For local1 = $01 To len(local0\Field2) Step $01
                Select mid(local0\Field2, local1, $01)
                    Case "i"
                        public_addparam((Str bytestreamreadint(local0\Field1)), $01)
                    Case "f"
                        public_addparam((Str bytestreamreadfloat(local0\Field1)), $02)
                    Case "s"
                        public_addparam(bytestreamreadstring(local0\Field1), $03)
                End Select
            Next
            public_update_by_func(local0\Field6, $00)
            public_clear()
            If (local0\Field5 <> 0) Then
                local0\Field4 = (millisecs() + local0\Field3)
                bytestreamresetread(local0\Field1)
            Else
                removetimer(local0)
            EndIf
        EndIf
    Next
    Return $00
End Function
