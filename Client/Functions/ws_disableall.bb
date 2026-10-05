Function ws_disableall%()
    Local local0.workshopthread
    For local0 = Each workshopthread
        If (local0\Field2 <> Null) Then
            public_inqueue($11, $00)
            public_update_current(local0\Field2, $00)
            public_clear()
            se_deletescript(local0\Field2)
        EndIf
        Delete local0
    Next
    workshop_script_count = $00
    Return $00
End Function
