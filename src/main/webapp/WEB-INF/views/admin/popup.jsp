<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div id="modal">
        <div id="frame" >
          
            <div class="form-group">
            	<div class="frame-title bg-primary" >
            		<label id="inputTitle">Confirm</label>
            	</div>
                <div class="frame-content col-12">
                   <p>  <span id="typeEvent">Do you want to delelte this?</span>  <br> 
                    <span id="inputText"></span>
                    </p>
                    <input type="hidden" id="idHidden" >
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <button type="button" id="btnExe" class="btn btn-primary btn-frame" onclick="execute()">Ok</button> 
                    <input type="button" id="btnCancel" class="btn btn-danger btn-frame" onclick="hide()" value="Cancel">
                </div>
            </div>
        </div>
    </div>
