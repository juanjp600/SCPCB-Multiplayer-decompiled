Function ws_disableall%()
    Local local0.workshopthread
    For local0 = Each workshopthread
        public_inqueue($11, $00)
        public_update_current(local0\Field2, $00)
        public_clear()
        se_deletescript(local0\Field2)
        workshop_script_count = (workshop_script_count - $01)
    Next
    Return $00
End Function
