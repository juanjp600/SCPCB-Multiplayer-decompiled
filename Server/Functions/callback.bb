Function callback%(arg0%)
    Local local0.scriptsthread
    se_return_value\Field0 = $00
    se_return_value\Field8 = $00
    For local0 = Each scriptsthread
        public_update_current(local0, arg0)
    Next
    public_clear()
    Return $00
End Function
