Function callback%()
    Local local0.scriptsthread
    Local local1.workshopthread
    se_return_value\Field0 = $00
    se_return_value\Field8 = $00
    For local0 = Each scriptsthread
        public_update_current(local0\Field0, $00)
    Next
    workshopexecute = $01
    For local1 = Each workshopthread
        public_update_current(local1\Field2, $00)
    Next
    workshopexecute = $00
    public_clear()
    Return $00
End Function
